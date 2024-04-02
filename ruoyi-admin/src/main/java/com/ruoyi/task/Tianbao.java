package com.ruoyi.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.domain.Order;
import com.ruoyi.service.InterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.List;
/*
 * 
 * @author: majizhao
 * @date: 2024/3/13 13:30 
 * @return: null
 * @throws: 
 **/
@Component("tianBaoTask")
public class Tianbao {
    private static final Logger log = LoggerFactory.getLogger(Tianbao.class);
    private static final String TIANBAOBaseUrl = "http://{ip}:{port}/api/v1/xy_data/";
    @Autowired
    InterfaceService interfaceService;
    /*
     * 
     * @author: majizhao 
     * @date: 2024/3/13 10:19 
     * @return: null
     * @throws: 
     **/
   public void getOrderList(String begin_date,String end_date) throws Exception {
       if(StringUtils.isEmpty(begin_date) || StringUtils.isEmpty(end_date)){
           LocalDate today = LocalDate.now();
           LocalDate previousDay = today.minusDays(1);
           begin_date = previousDay.toString();
           end_date = previousDay.toString();
       }
       JSONObject jsonParam = new JSONObject();
       jsonParam.put("begin_date",begin_date);
       jsonParam.put("end_date",end_date);
       
       String param = JSON.toJSONString(jsonParam);
       log.info("【调用天宝接口获取工单信息】,请求参数：{}",param);
       String orderResult = HttpUtils.sendPost(TIANBAOBaseUrl + "po_data",param);
       log.info("【调用天宝接口获取工单信息】,返回结果：{}",orderResult);
       JSONObject jsonObject = JSON.parseObject(orderResult);
       if(StringUtils.isEmpty(orderResult) || !jsonObject.get("code").equals(Constants.SUCCESS)){
           throw new Exception(StringUtils.format("调用天宝接口获取工单信息失败。", jsonObject.get("msg")));
       }
       List<Order> orderList = (List<Order>)jsonObject.get("data");
       if(ObjectUtils.isEmpty(orderList)){
           throw new Exception(StringUtils.format("调用天宝接口获取工单信息成功，但是返回订单信息为空。", jsonObject.get("msg")));
       }
       interfaceService.insertOrderList(orderList);
   }
}
