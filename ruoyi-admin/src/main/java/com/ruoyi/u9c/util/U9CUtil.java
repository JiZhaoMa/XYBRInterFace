package com.ruoyi.u9c.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.task.U9COrgTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class U9CUtil {
    private static final Logger log = LoggerFactory.getLogger(U9CUtil.class);
    @Value("${U9C.url}")
    private  String url;
    @Value("${U9C.clientid}")
    private  String clientid;
    @Value("${U9C.clientsecret}")
    private  String clientsecret;
    @Value("${U9C.entCode}")
    private  String entCode;
    @Value("${U9C.userCode}")
    private  String userCode;
    @Value("${U9C.orgCode}")
    private  String orgCode;
    public String getToken() throws Exception {
        String param = "clientid="+clientid+"&clientsecret="+clientsecret;
        log.info("【调用U9C接口获取授权码信息】,请求参数：{}",param);
        String result = HttpUtils.sendGet(url + "OAuth2/GetAuthorizeCode",param);
        log.info("【调用U9C接口获取授权码信息】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(StringUtils.format("调用U9C接口获取授权码信息失败。", jsonObject.get("ResMsg")));
        }
        String secret = jsonObject.get("Data").toString();
        param = "entCode="+entCode+"&userCode="+userCode+"&orgCode="+orgCode+"&code=" + secret;
        log.info("【调用U9C接口获取信息】,请求参数：{}",param);
        result = HttpUtils.sendGet(url + "OAuth2/Login",param);
        log.info("【调用U9C接口获取token信息】,返回结果：{}",result);
        jsonObject = JSON.parseObject(result);
        if(StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(StringUtils.format("调用U9C接口获取token信息失败。", jsonObject.get("errmsg")));
        }
        String token = jsonObject.get("Data").toString();
        return token;
    }
    public JSONObject postU9CApi(String param,String apiUrl,String apiName) throws Exception {
        String token = getToken();
        log.info("【调用U9C接口"+ apiName +"】,请求参数：{}",param);
        HttpRequest request = HttpRequest.post(url + apiUrl).header("token",token);
        HttpResponse response = request.body(param).execute();
        String result = response.body();
        log.info("【调用U9C接口"+ apiName +"】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        return jsonObject;
    }
}
