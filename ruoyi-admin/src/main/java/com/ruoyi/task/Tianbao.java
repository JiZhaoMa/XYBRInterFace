package com.ruoyi.task;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.domain.*;
import com.ruoyi.service.InterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static final String TIANBAOBaseUrl = "http://119.146.70.115:28888/api/v1/xy_data/";
    @Value("${TianBao.HOST}")
    private String HOST;
    @Value("${TianBao.Tenant_Id}")
    private String  Tenant_Id;
    @Value("${TianBao.Authorization}")
    private String  Authorization;
    @Value("${TianBao.grant_type}")
    private String  grant_type;
    @Value("${TianBao.scope}")
    private String  scope;
    @Value("${TianBao.username}")
    private String  username;
    @Value("${TianBao.password}")
    private String  password;
    @Autowired
    InterfaceService interfaceService;
    /*
     * 
     * @author: majizhao 
     * @date: 2024/3/13 10:19 
     * @return: null
     * @throws: 
     **/
   public void getOrderList(String begin_date,String end_date, String agent) throws Exception {
       List<InterFaceOrder> orderList = new ArrayList<>();
       orderList = (List<InterFaceOrder>) api("星源工单",begin_date,end_date,"po_data",orderList);
       if(orderList.size() > 0){
           interfaceService.insertOrderList(orderList);
       }
   }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getAgentOrderList(String begin_date,String end_date, String agent) throws Exception {
        List<InterFaceAgentOrder> agentOrder = new ArrayList<>();
        agentOrder = (List<InterFaceAgentOrder>) api("工厂工单",begin_date,end_date,"mo_data",agentOrder);
        if(agentOrder.size() > 0){
            interfaceService.insertAgentOrderList(agentOrder);
        }
    }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getProcessDataList(String begin_date,String end_date, String agent) throws Exception {
        List<InterFaceProcessData> processData = new ArrayList<>();
        processData = (List<InterFaceProcessData>) api("直通率",begin_date,end_date,"process_data",processData);
        if(processData.size() > 0){
            interfaceService.insertProcessDataList(processData);
        }
    }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getInStoreData(String begin_date,String end_date, String agent) throws Exception {
        List<InterFaceInStoreData> inStoreData = new ArrayList<>();
        inStoreData = (List<InterFaceInStoreData>) api("入库",begin_date,end_date,"in_store_data",inStoreData);
        if(inStoreData.size() > 0){
            interfaceService.insertInstoreDataList(inStoreData);
        }
    }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getShippingData(String begin_date,String end_date, String agent) throws Exception {
        List<InterFaceShippingData> shippingData = new ArrayList<>();
        shippingData = (List<InterFaceShippingData>) api("发货",begin_date,end_date,"shipping_data",shippingData);
        if(shippingData.size() > 0){
            interfaceService.insertShippingDataList(shippingData);
        }
    }
    /*
     *
     * @author: majizhao
     * @date: 2024/3/13 10:19
     * @return: null
     * @throws:
     **/
    public void getStockData(String begin_date,String end_date, String agent) throws Exception {
        List<InterFaceStockData> stockList = new ArrayList<>();
        stockList = (List<InterFaceStockData>) api("库存",begin_date,end_date,"stock_data",stockList);
        if(stockList.size() > 0){
            interfaceService.insertStockDataList(stockList);
            interfaceService.insertHistoryStockDataList(stockList);
            interfaceService.deleteStockData();
        }
    }

    public List<?> api(String apiName, String begin_date,String end_date,String url, List<?> list) throws Exception {
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
        log.info("【调用天宝接口获取"+ apiName +"信息】,请求参数：{}",param);
        HttpRequest request = HttpRequest.post(TIANBAOBaseUrl + url)
                        .header("Blade-Auth","bearer " + getToken())
                        .header("Authorization", Authorization);
        HttpResponse response = request.body(param).execute();
        String orderResult = response.body();
        log.info("【调用天宝接口获取"+ apiName +"信息】,返回结果：{}",orderResult);
        JSONObject jsonObject = JSON.parseObject(orderResult);
        if(StringUtils.isEmpty(orderResult) && !jsonObject.get("code").equals(Constants.APISUCCESS)){
            throw new Exception(StringUtils.format("调用天宝接口获取"+ apiName +"信息失败。", jsonObject.get("msg")));
        }
        list = (List<?>)jsonObject.get("data");
        if(ObjectUtils.isEmpty(list)){
            throw new Exception(StringUtils.format("调用天宝接口获取"+ apiName +"信息成功，但是返回"+ apiName +"信息为空。", jsonObject.get("msg")));
        }
        return list;
    }
    public String getToken() throws Exception {
        String Tenant_Id = "272026";
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("grant_type",grant_type);
        jsonParam.put("scope",scope);
        jsonParam.put("username",username);
        jsonParam.put("password",password);
        jsonParam.put("tenantId",Tenant_Id);

        String param = JSON.toJSONString(jsonParam);
        String url = "http://119.146.70.115:28888/blade-auth/oauth/token?password=" + password + "&grant_type=" + grant_type + "&scope=" + scope + "&username=" + username + "&tenantId=" + Tenant_Id;
        String orderResult = HttpUtils.sendPostToken(url,param, Authorization, "");
        log.info("【调用天宝接口获取token信息】,返回结果：{}",orderResult);
        JSONObject jsonObject = JSON.parseObject(orderResult);
        String token = jsonObject.get("access_token").toString();
        System.out.println(token);
        return token;
    }
}
