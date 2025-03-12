package com.ruoyi.task;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.proxyFactory.domain.*;
import com.ruoyi.proxyFactory.service.InterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
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
    @Autowired
    InterfaceService interfaceService;
    public List<InterFaceDomain> getInterFaceList(String interFaceName){
        List<InterFaceDomain> list = new ArrayList<>();
        InterFaceDomain i = new InterFaceDomain();
        i.setInterFaceName(interFaceName);
        list = interfaceService.getInterFaceList(i);
        return list;
    }
    /*
     * 
     * @author: majizhao 
     * @date: 2024/3/13 10:19 
     * @return: null
     * @throws: 
     **/
   public void getOrderList(String begin_date,String end_date, String interFaceName) throws Exception {
       List<InterFaceOrder> orderList = new ArrayList<>();
       List<InterFaceDomain> list = getInterFaceList(interFaceName);
       for(InterFaceDomain interFaceDomain : list){
           orderList = (List<InterFaceOrder>) api(interFaceDomain,begin_date,end_date,orderList);
           if(orderList.size() > 0){
               interfaceService.insertOrderList(orderList);
           }
       }
   }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getAgentOrderList(String begin_date,String end_date, String interFaceName) throws Exception {
        List<InterFaceAgentOrder> agentOrder = new ArrayList<>();
        List<InterFaceDomain> list = getInterFaceList(interFaceName);
        for(InterFaceDomain interFaceDomain : list){
            agentOrder = (List<InterFaceAgentOrder>) api(interFaceDomain,begin_date,end_date,agentOrder);
            if(agentOrder.size() > 0){
                interfaceService.insertAgentOrderList(agentOrder);
            }
        }
    }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getProcessDataList(String begin_date,String end_date, String interFaceName) throws Exception {
        List<InterFaceProcessData> processData = new ArrayList<>();
        List<InterFaceDomain> list = getInterFaceList(interFaceName);
        for(InterFaceDomain interFaceDomain : list){
            processData = (List<InterFaceProcessData>) api(interFaceDomain,begin_date,end_date,processData);
            if(processData.size() > 0){
                interfaceService.insertProcessDataList(processData);
            }
        }
    }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getInStoreData(String begin_date,String end_date, String interFaceName) throws Exception {
        List<InterFaceInStoreData> inStoreData = new ArrayList<>();
        List<InterFaceDomain> list = getInterFaceList(interFaceName);
        for(InterFaceDomain interFaceDomain : list){
            inStoreData = (List<InterFaceInStoreData>) api(interFaceDomain,begin_date,end_date,inStoreData);
            if(inStoreData.size() > 0){
                interfaceService.insertInstoreDataList(inStoreData);
            }
        }
    }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getShippingData(String begin_date,String end_date, String interFaceName) throws Exception {
        List<InterFaceShippingData> shippingData = new ArrayList<>();
        List<InterFaceDomain> list = getInterFaceList(interFaceName);
        for(InterFaceDomain interFaceDomain : list){
            shippingData = (List<InterFaceShippingData>) api(interFaceDomain,begin_date,end_date,shippingData);
            if(shippingData.size() > 0){
                interfaceService.insertShippingDataList(shippingData);
            }
        }
    }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getStockData(String begin_date,String end_date, String interFaceName) throws Exception {
        List<InterFaceStockData> stockList = new ArrayList<>();
        List<InterFaceDomain> list = getInterFaceList(interFaceName);
        for(InterFaceDomain interFaceDomain : list){
            stockList = (List<InterFaceStockData>) api(interFaceDomain,begin_date,end_date,stockList);
            if(stockList.size() > 0){
                interfaceService.deleteStockData();
                interfaceService.insertStockDataList(stockList);
                interfaceService.insertHistoryStockDataList(stockList);
            }
        }
    }

    public List<?> api(InterFaceDomain interFaceDomain, String begin_date,String end_date, List<?> list) throws Exception {
        String apiUrl = interFaceDomain.getHost() + interFaceDomain.getUrl();
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
        log.info("【调用" +interFaceDomain.getTarget()+ "接口获取"+ interFaceDomain.getInterFaceName() +"信息】,请求参数：{}",param);
        HttpRequest request = HttpRequest.post(apiUrl)
                        .header("Blade-Auth","bearer " + getToken(interFaceDomain))
                        .header("Authorization", interFaceDomain.getAuthorization());
        HttpResponse response = request.body(param).execute();
        String orderResult = response.body();
        log.info("【调用" +interFaceDomain.getTarget()+ "接口获取"+ interFaceDomain.getInterFaceName() +"信息】,返回结果：{}",orderResult);
        JSONObject jsonObject = JSON.parseObject(orderResult);
        if(StringUtils.isEmpty(orderResult) && !jsonObject.get("code").equals(Constants.APISUCCESS)){
            throw new Exception(StringUtils.format("调用" +interFaceDomain.getTarget()+ "接口获取"+ interFaceDomain.getInterFaceName() +"信息失败。", jsonObject.get("msg")));
        }
        list = (List<?>)jsonObject.get("data");
        if(ObjectUtils.isEmpty(list)){
            throw new Exception(StringUtils.format("调用" +interFaceDomain.getTarget()+ "接口获取"+ interFaceDomain.getInterFaceName() +"信息成功，但是返回"+ interFaceDomain.getInterFaceName() +"信息为空。", jsonObject.get("msg")));
        }
        return list;
    }
    public String getToken(InterFaceDomain interFaceDomain) throws Exception {
        JSONObject jsonParam = new JSONObject();
        interFaceDomain.setInterFaceName("token");
        String token = "";
        List<InterFaceDomain> list = interfaceService.getInterFaceList(interFaceDomain);
        interFaceDomain = list.get(0);
        jsonParam.put("grant_type",interFaceDomain.getGrantType());
        jsonParam.put("scope",interFaceDomain.getScope());
        jsonParam.put("username",interFaceDomain.getUsername());
        jsonParam.put("password",interFaceDomain.getPassword());
        jsonParam.put("tenantId",interFaceDomain.getTenantId());
        String param = JSON.toJSONString(jsonParam);
        String apiUrl = interFaceDomain.getHost() + interFaceDomain.getUrl();
        String url = apiUrl + "?password=" + interFaceDomain.getPassword() + "&grant_type=" + interFaceDomain.getGrantType() + "&scope=" + interFaceDomain.getScope() + "&username=" + interFaceDomain.getUsername() + "&tenantId=" + interFaceDomain.getTenantId();
        if("天宝".equals(interFaceDomain.getTarget())){
            String orderResult = HttpUtils.sendPostToken(url,param, interFaceDomain.getAuthorization(), "");
            log.info("【调用天宝接口获取token信息】,返回结果：{}",orderResult);
            JSONObject jsonObject = JSON.parseObject(orderResult);
            token = jsonObject.get("access_token").toString();
        }
        if("四联".equals(interFaceDomain.getTarget())){
            String orderResult = HttpUtils.sendGet(url,param);
            log.info("【调用四联接口获取token信息】,返回结果：{}",orderResult);
            JSONObject jsonObject = JSON.parseObject(orderResult);
            token = jsonObject.get("token").toString();
        }
        return token;
    }
}
