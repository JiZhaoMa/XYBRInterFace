package com.smwl.wbdj.aspectj;

import cn.hutool.db.sql.Order;
import com.alibaba.fastjson2.JSON;
import com.smwl.common.constant.CacheConstants;
import com.smwl.common.constant.WbdjConstants;
import com.smwl.common.core.domain.AjaxResult;
import com.smwl.common.core.redis.RedisCache;
import com.smwl.common.exception.ServiceException;
import com.smwl.common.utils.StringUtils;
import com.smwl.system.domain.OrderInterInfo;
import com.smwl.system.domain.OrderPlatInfo;
import com.smwl.system.domain.vo.TokenCacheVo;
import com.smwl.system.mapper.OrderPlatInfoMapper;
import com.smwl.wbdj.service.PlatCacheService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * @author MJZ
 * @version 1.0
 * @date 2024/3/20  11:43
 * @Filename：TokenValidationAspect
 */
@Aspect
@Component
public class TokenValidationAspect {

    private Logger logger = LoggerFactory.getLogger(TokenValidationAspect.class);

    private static final int STATUS = 2;
    private static final int DEL_FLAG = 0;


    @Autowired
    private PlatCacheService platCacheService;
    @Autowired
    private OrderPlatInfoMapper platInfoMapper;


    @Pointcut("@annotation(com.smwl.wbdj.annotation.TokenValidation)")
    public void tokenValidationPointcut() {}



    @Around("tokenValidationPointcut()")
    public Object validateTokenAndLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //从请求中获取token、请求路径、请求方式
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestMethod = request.getMethod();
        String requestPath = request.getRequestURI();
        // 调用 tokenValidator 进行校验
        return validateToken(joinPoint,requestPath,requestMethod);
    }

    @AfterReturning(pointcut = "@annotation(com.smwl.wbdj.annotation.TokenValidation)", returning = "result")
    public void processResponse(JoinPoint joinPoint, Object result) {
        System.out.println("请求合法性校验通过: " + result.toString());
    }

    /**
     * 校验请求的合法性
     *
     * @param joinPoint
     * @param requestPath 请求接口路径
     * @param method      请求方法
     * @return
     */
    public Object validateToken(ProceedingJoinPoint joinPoint, String requestPath, String method) throws Throwable {
        logger.info("================================开始校验请求合法性================================");
        Map<String,String> map = platCacheService.getTokenFromRequest();
        String token = map.get("token");
        Claims claims = Jwts.parser()
                .setSigningKey(WbdjConstants.SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        String appKey = claims.get("appKey", String.class);
        String appSecret = claims.get("appSecret", String.class);
        long timestamp = claims.get("timestamp", Long.class);
        OrderPlatInfo platInfo = platInfoMapper.selectOrderPlatInfoByAppKey(appKey);
        if (ObjectUtils.isEmpty(platInfo)){
            return AjaxResult.error("当前appKey对应的平台信息不存在");
        }
        TokenCacheVo cacheVo = platCacheService.getPlatCacheFromRedisOrDb(CacheConstants.API_ACCSEE_KEY + appKey,platInfo);
        logger.info("【从缓存或数据库获取到的平台缓存信息为】：{}", JSON.toJSONString(cacheVo));
        //① 平台未接入  ②平台原来接入但现在已停用
        OrderPlatInfo contThirdPlat = cacheVo.getOrderPlatInfo();
        if(ObjectUtils.isEmpty(contThirdPlat) || STATUS != contThirdPlat.getStatus()){
            return AjaxResult.error("未接入【自助下单微应用】或已停止授权");
        }
        //③请求接口未授权或已停用
        List<OrderInterInfo> list = cacheVo.getOrderInterInfos();
        Optional<OrderInterInfo> result = list.stream()
                .filter(obj->obj.getUrl().equals(requestPath))
                .findFirst();
        logger.info("【当前接口信息为】：{}",JSON.toJSONString(result));
        if(result.isPresent()){
            //④接口请求方式不运行
            OrderInterInfo thisInterface = result.get();
            if(!method.equals(thisInterface.getTypeName())){
                return AjaxResult.error("请求方式错误");
            }
        }else {
            return AjaxResult.error("接口未授权或已停用");
        }
        //token已过期
        long nowTimeStamp = System.currentTimeMillis();
        if(!platCacheService.checkToken(timestamp,nowTimeStamp,platInfo.getTokenTime())){
            return AjaxResult.error("TOKEN已过期");
        }
        //用户携带的token同新的token做比较
        String newToken = Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject("token")
                .claim("appKey",appKey)
                .claim("appSecret",appSecret)
                .claim("timestamp",timestamp)
                .signWith(SignatureAlgorithm.HS512, WbdjConstants.SECRET_KEY).compact();
        if(!newToken.equals(token)){
            return AjaxResult.error("TOKEN不合法，请重新申请TOKEN");
        }
        logger.info("================================校验请求合法性校验通过================================");
        // 继续执行原始方法
        return joinPoint.proceed();
    }




}
