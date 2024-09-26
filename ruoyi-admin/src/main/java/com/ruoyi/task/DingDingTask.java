package com.ruoyi.task;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.domain.DingDingUser;
import com.ruoyi.service.DingDingService;
import com.ruoyi.u9c.domain.ItemInfo;
import com.ruoyi.u9c.service.ItemInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("dingDingTask")
public class DingDingTask {
    private static final Logger log = LoggerFactory.getLogger(Tianbao.class);
    private static final String url = "https://oapi.dingtalk.com/gettoken";
    private static final String getUserUrl = "https://oapi.dingtalk.com/topapi/v2/user/get";
    @Autowired
    DingDingService dingDingService;
    public void updateJobNumber() throws Exception {
        List<DingDingUser> list = dingDingService.getUserList();
        String token = getToken();
        for(DingDingUser dingDingUser: list){
            Map<String,String> resultMap = getJobNumber(token,dingDingUser.getDdUserId());
            dingDingUser.setJobNumber(resultMap.get("jobNumber"));
            dingDingUser.setDepartmentId(resultMap.get("depId"));
            dingDingUser.setManagerUserId(resultMap.get("managerUserId"));
            DingDingUser dingUser = dingDingService.getUserId(dingDingUser);
            dingDingUser.setManagerUserId(dingUser==null ? "" : dingUser.getManagerUserId());
        }
        dingDingService.updateJobNumber(list);
    }
    public String getToken() throws Exception {
        String param = "appkey=dinght5lpyqkv0gkfvg8&appsecret=uNBJdLIlY-h7MkmsL5NS3q5-tpaiSmic2zKIa_UPV8kXyxQ9xbV0r0019B_4m2H0";
        log.info("【调用钉钉接口获取token信息】,请求参数：{}",param);
        String result = HttpUtils.sendGet(url,param);
        log.info("【调用钉钉接口获取token信息】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(StringUtils.isEmpty(result) && !jsonObject.get("errcode").toString().equals("0")){
            throw new Exception(StringUtils.format("调用钉钉接口获取token信息失败。", jsonObject.get("errmsg")));
        }
        String token = jsonObject.get("access_token").toString();
        return token;
    }
    public Map<String,String> getJobNumber(String token,String userid) throws Exception {
        String param = "access_token="+token+"&userid="+userid;
        log.info("【调用钉钉接口获取用户信息】,请求参数：{}",param);
        String body = HttpUtils.sendGet(getUserUrl,param);
        log.info("【调用钉钉接口获取用户信息】,返回结果：{}",body);
        JSONObject jsonObject = JSON.parseObject(body);
        if(StringUtils.isEmpty(body) && !jsonObject.get("errcode").toString().equals("0")){
            throw new Exception(StringUtils.format("调用钉钉接口获取用户信息失败。", jsonObject.get("errmsg")));
        }
        String result = jsonObject.get("result").toString();
        JSONObject jsonResult = JSON.parseObject(result);
        String jobNumber = jsonResult.get("job_number") == null ? "" : jsonResult.get("job_number").toString();
        String managerUserId = jsonResult.get("manager_userid") == null ? "" : jsonResult.get("manager_userid").toString();
        JSONArray jsonArray = (JSONArray) jsonResult.get("dept_order_list");
        JSONObject depJson = (JSONObject) jsonArray.get(0);
        String depId = depJson.get("dept_id").toString();
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("jobNumber",jobNumber);
        resultMap.put("managerUserId",managerUserId);
        resultMap.put("depId",depId);
        return resultMap;
    }
}
