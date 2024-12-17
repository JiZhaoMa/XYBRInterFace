package com.smwl.wbdj.service;

import com.smwl.common.constant.WbdjConstants;
import com.smwl.common.core.redis.RedisCache;
import com.smwl.common.exception.ServiceException;
import com.smwl.common.utils.DateUtils;
import com.smwl.common.utils.StringUtils;
import com.smwl.system.domain.OrderInterInfo;
import com.smwl.system.domain.OrderPlatInfo;
import com.smwl.system.domain.vo.TokenCacheVo;
import com.smwl.system.service.IOrderInterInfoService;
import com.smwl.system.service.IOrderPlatInfoService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author MJZ
 * @version 1.0
 * @date 2024/3/20  11:03
 * @Filename：PlatCacheService
 */
@Service
public class PlatCacheService {

    @Autowired
    private IOrderInterInfoService interInfoService;
    @Autowired
    RedisCache redisCache;
    @Autowired
    private IOrderPlatInfoService platInfoService;


    /**
     * 外部系统申请token时，将相关信息存入缓存
     * @param appKey
     * @param platInfo
     * @return
     */
    public TokenCacheVo firstCachePlatInfo(String appKey,OrderPlatInfo platInfo){
        TokenCacheVo tokenCacheVo = new TokenCacheVo();
        //步骤一 删除缓存
        redisCache.deleteObject(appKey);
        //步骤二 创建缓存
        tokenCacheVo.setOrderPlatInfo(platInfo);
        OrderInterInfo requestParam = new OrderInterInfo();
        if(ObjectUtils.isNotEmpty(platInfo)){
            requestParam.setPlatId(platInfo.getId());
            List<OrderInterInfo> platInters = interInfoService.getAuthInterface(requestParam);
            tokenCacheVo.setOrderInterInfos(platInters);
        }
        tokenCacheVo.setCreateTime(DateUtils.getNowDate());
        long timestamp = platInfo.getTokenTime() * 60 * 60;
        redisCache.setCacheObject(appKey,tokenCacheVo,(int) timestamp, TimeUnit.SECONDS);
        return tokenCacheVo;
    }


    /**
     * 从数据库或缓存中获取平台相关信息
     * @param appKey 平台唯一Key（缓存key）
     * @return
     */
    public TokenCacheVo getPlatCacheFromRedisOrDb(String appKey,OrderPlatInfo platInfo){
        TokenCacheVo tokenCacheVoCache =  redisCache.getCacheObject(appKey);
        //当缓存中为空的时候，从数据查询组装相关信息放入缓存
        if(ObjectUtils.isEmpty(tokenCacheVoCache)){
            tokenCacheVoCache = firstCachePlatInfo(appKey,platInfo);
        }
        return tokenCacheVoCache;
    }


    /**
     * 计算token理论过期时间，并判断此时是否过期
     * @param getTime
     * @param nowTime
     * @param yxq
     * @return
     */
    public boolean checkToken(long getTime,long nowTime,int yxq){
        //token理论过期时间
        long timestamp = getTime + ((long) yxq * 60 * 60 * 1000);
        return nowTime < timestamp;
    }


    /**
     * 更新外部平台缓存信息  新增接口授权或取消接口授权时调用
     * @param redisKey
     * @param interIds
     * @param flag    add表示新增授权时   cancel表示取消授权时调用
     * @return
     */
    public void updatePlatCache(String redisKey,Long[] interIds,String flag,OrderPlatInfo platInfo){
        //获取整个缓存数据
        TokenCacheVo tokenCacheVo = redisCache.getCacheObject(redisKey);
        if(ObjectUtils.isEmpty(tokenCacheVo)){
            tokenCacheVo = firstCachePlatInfo(redisKey,platInfo);
        }
        //获取原来的有效期
        Long expiration = redisCache.getExpire(redisKey);
        List<OrderInterInfo> interInfos = tokenCacheVo.getOrderInterInfos();
        if("add".equals(flag)){
            for (long interId: interIds) {
                OrderInterInfo addInfo = interInfoService.selectOrderInterInfoById(interId);
                if(ObjectUtils.isNotEmpty(addInfo)){
                    interInfos.add(addInfo);
                }
            }
        }
        if("cancel".equals(flag)){
            //迭代器删除
            Iterator<OrderInterInfo> iterator = interInfos.listIterator();
            while (iterator.hasNext()){
                if(iterator.next().getId().equals(interIds[0])){
                    iterator.remove();
                }
            }
        }
        tokenCacheVo.setOrderInterInfos(interInfos);
        redisCache.updateCache(redisKey,tokenCacheVo,expiration);
    }


    /**
     * 从请求中获取token与appKey、appName
     * @return
     */
    public Map<String,String> getTokenFromRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 从请求头中获取token
        String authorizationHeader  = request.getHeader("Authorization");
        // 提取Bearer令牌
        String token = null;
        if (authorizationHeader != null) {
            if(authorizationHeader.startsWith("Bearer ")){
                token = authorizationHeader.substring(7);
            }else {
                token = authorizationHeader;
            }
        }
        // 如果请求头中没有Authorization字段，则尝试从请求参数中获取
        if (token == null || token.isEmpty()) {
            token = request.getParameter("token");
        }
        if(StringUtils.isEmpty(token)){
            throw new ServiceException("token不能为空！！！！");
        }
        Claims claims = Jwts.parser()
                .setSigningKey(WbdjConstants.SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        String appKey = claims.get("appKey", String.class);
        OrderPlatInfo orderPlatInfo = platInfoService.selectOrderPlatInfoByAppKey(appKey);
        if(ObjectUtils.isEmpty(orderPlatInfo)){
            throw new ServiceException("当前平台信息不存在");
        }
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("token",token);
        hashMap.put("appKey",appKey);
        hashMap.put("platName",orderPlatInfo.getPlatName());
        return hashMap;
    }

}
