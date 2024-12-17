package com.ruoyi.api.controller;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.ruoyi.api.domian.CacheConstants;
import com.ruoyi.api.domian.OrderPlatInfo;
import com.ruoyi.api.domian.WbdjConstants;
import com.ruoyi.api.service.IOrderPlatInfoService;
import com.ruoyi.api.service.PlatCacheService;
import com.ruoyi.api.util.TokenValidation;
import com.ruoyi.common.core.domain.AjaxResult;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/XYBR")
@RestController
public class WbApiContrller {

    private Logger logger = LoggerFactory.getLogger(WbApiContrller.class);
    @Autowired
    IOrderPlatInfoService platInfoService;
    @Autowired
    PlatCacheService cacheService;
//    @Autowired
//    ITptTransInfoServi tptTransInfoService;
//    @Autowired
//    IOdrProducerOrderService odrProducerOrderService;

    /**
     * 外部系统申请token接口
     * @param appKey       系统分配的appKey
     * @param appSecret    系统分配的appSecret
     * @param timestamp    申请时间戳
     * @return
     */
    @GetMapping("/getToken")
    public AjaxResult applyPlatToken(String appKey, String appSecret, long timestamp){
        logger.info("【第三方对接平台通过appKey换取token接口】请求参数：appKey:{},appSecret:{},timestamp:{}",
                appKey,appSecret,timestamp);
        if(StringUtils.isBlank(appKey) || StringUtils.isBlank(appSecret) || timestamp == 0){
            return AjaxResult.error("appKey或appSecret或timestamp不能为空");
        }
        OrderPlatInfo platInfo = platInfoService.selectOrderPlatInfoByAppKey(appKey.replace(CacheConstants.API_ACCSEE_KEY, ""));
        if(ObjectUtil.isEmpty(platInfo)){
            return AjaxResult.error("当前appKey对应的平台信息不存在");
        }
        try {
            String token = Jwts.builder()
                    .setHeaderParam("type","JWT")
                    .setSubject("token")
                    .claim("appKey",appKey)
                    .claim("appSecret",appSecret)
                    .claim("timestamp",timestamp)
                    .signWith(SignatureAlgorithm.HS512, WbdjConstants.SECRET_KEY).compact();
            cacheService.firstCachePlatInfo(CacheConstants.API_ACCSEE_KEY + appKey,platInfo);
            logger.info("【第三方对接平台通过appKey换取token接口】响应结果：{}", JSON.toJSONString(AjaxResult.success("请求成功",token)));
            return AjaxResult.success("请求成功",token);
        }catch (Exception e){
            logger.error("【第三方对接平台通过appKey换取token接口】系统异常：{}", JSON.toJSONString(AjaxResult.error(e.getMessage())));
            return AjaxResult.error(e.getMessage());
        }
    }


    /**
     * 运单状态变更接口
     * @param
     * @return
     */
    @PostMapping("/order/changeStatus")
    @TokenValidation
    public AjaxResult handleOrderChange() {
        return AjaxResult.success("运单状态变更成功",null);
    }


    /**
     * 运输单(派车单)状态变更
     * @param pcdStatusChangeVO
     * @return
     */
//    @PostMapping("/wzc/transChange")
//    @PlatReqLog
//    @TokenValidation
//    public AjaxResult handleTptStatus(@RequestBody PcdStatusChangeVO pcdStatusChangeVO){
//        logger.info("接受我找车平台运单状态变更接口，请求参数：{}",JSON.toJSONString(pcdStatusChangeVO));
//        if(ObjectUtils.isEmpty(pcdStatusChangeVO) || StringUtils.isEmpty(pcdStatusChangeVO.getTransStatus()) ||
//                StringUtils.isEmpty(pcdStatusChangeVO.getOrderId()) || StringUtils.isEmpty(pcdStatusChangeVO.getDispatchNo())){
//            logger.error("接受我找车平台运单状态变更接口，参数校验不通过,请检查是否缺失必传字段");
//            return AjaxResult.platError(RespEnum.PARAM_ERROR);
//        }
//        TptTransInfo tptTransInfo = tptTransInfoService.selectTptTransInfoById(Long.valueOf(pcdStatusChangeVO.getOrderId()));
//        if (ObjectUtils.isEmpty(tptTransInfo)) {
//            logger.error("接受我找车平台运单状态变更接口，运单不存在");
//            return AjaxResult.platError(RespEnum.NOT_ORDER);
//        }
//        String transStatus =TptTransInfo.DictTransStatus. waitSjAccept;
//        if(WbdjConstants.WZC_TRANS_STATUS_0.equals(pcdStatusChangeVO.getTransStatus())){
//            transStatus = TptTransInfo.DictTransStatus.sjAccept;
//        }if(WbdjConstants.WZC_TRANS_STATUS_1.equals(pcdStatusChangeVO.getTransStatus())){
//            transStatus = TptTransInfo.DictTransStatus.startTrans;
//        }if(WbdjConstants.WZC_TRANS_STATUS_3.equals(pcdStatusChangeVO.getTransStatus())){
//            transStatus = TptTransInfo.DictTransStatus.carArrive;
//        }if(WbdjConstants.WZC_TRANS_STATUS_4.equals(pcdStatusChangeVO.getTransStatus())){
//            transStatus = TptTransInfo.DictTransStatus.takeGoods;
//        }if(WbdjConstants.WZC_TRANS_STATUS_6.equals(pcdStatusChangeVO.getTransStatus())){
//            transStatus = TptTransInfo.DictTransStatus.goodsArrive;
//        }if(WbdjConstants.WZC_TRANS_STATUS_7.equals(pcdStatusChangeVO.getTransStatus())){
//            transStatus = TptTransInfo.DictTransStatus.goodsDown;
//        }if(WbdjConstants.WZC_TRANS_STATUS_8.equals(pcdStatusChangeVO.getTransStatus())){
//            transStatus = TptTransInfo.DictTransStatus.hzSigned;
//        }
//        tptTransInfo.setTransStatus(transStatus);
//        tptTransInfo.setUpdateTime(DateUtils.getNowDate());
//        tptTransInfo.setWzcDispatchId(pcdStatusChangeVO.getDispatchNo());
//        tptTransInfoService.updateTptTransInfo(tptTransInfo);
//        //判断当前运单对应的订单号是否存在多个运单  如果只有一个运单则根据当前运单判断订单的状态
//        TptTransInfo param = new TptTransInfo();
//        param.setProducerOrderId(tptTransInfo.getProducerOrderId());
//        List<TptTransInfo> list = tptTransInfoService.selectTptTransInfoList(param);
//        OdrProducerOrder updateParam = new OdrProducerOrder();
//        updateParam.setId(tptTransInfo.getProducerOrderId());
//        if(list.size() == 1){ //只有一个运单  我找车给的本运单状态为货主签收  则该订单状态为12拉运完成  反正则设置订单状态为11拉运中
//            if(WbdjConstants.WZC_TRANS_STATUS_8.equals(pcdStatusChangeVO.getTransStatus())){
//                updateParam.setOrderStatus("12");
//            }else {
//                updateParam.setOrderStatus("11");
//            }
//        }else {
//            int finalSize = 0;
//            for (TptTransInfo vo:list) {
//                if(TptTransInfo.DictTransStatus.hzSigned.equals(vo.getTransStatus())){
//                    finalSize = finalSize ++;
//                }
//            }
//            if(list.size() == finalSize){ //已完成的运单数与当前订单关联的运单数相同  则该订单状态设置为已完成
//                updateParam.setOrderStatus("12");
//            }else {
//                updateParam.setOrderStatus("11");
//            }
//        }
//        odrProducerOrderService.updateOdrProducerOrder4dealer(updateParam);
//        logger.info("接受我找车平台运单状态变更接口，响应结果：{}",JSON.toJSONString(AjaxResult.success("状态变更成功")));
//        return AjaxResult.success("状态变更成功");
//    }

}
