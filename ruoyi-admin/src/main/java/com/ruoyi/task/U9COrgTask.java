package com.ruoyi.task;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.domain.Department;
import com.ruoyi.domain.User;
import com.ruoyi.service.BPMService;
import com.ruoyi.service.U9CService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component("u9cOrgTask")
public class U9COrgTask {
    private static final Logger log = LoggerFactory.getLogger(U9COrgTask.class);
    private static final String url = "http://120.46.188.100/u9c/webapi/";
    @Autowired
    U9CService u9CService;
    @Autowired
    BPMService bpmService;
    public void updateDept() throws Exception {
        int level = 1;
        List<Department> list = bpmService.getDepartList(level);
        while(list.size() > 0) {
            //查询level层级的部门
            for(Department department : list){
                //根据部门名称匹配U9C中的部门信息
                List<Department> deptList = u9CService.getU9CDeptByName(department.getDeptName());
                if(deptList.size() <= 0){
                    //部门编码
                    department.setLevel(level);
                    Department d = u9CService.getDepartCode(department);
                    department.setU9cCode(d.getU9cCode());
                    //调用U9C新增部门接口
                    addDeptU9C(getToken(), department);
                }else{
                   for(Department d : deptList){
                        bpmService.updateDeptU9CCode(d);
                   }
                }
            }
            level ++;
            list = bpmService.getDepartList(level);
        }
    }
    public void updateU9CUserInfo() throws Exception {
        List<User> list = bpmService.getUserList();
        for(User user:list){
            User u9c = u9CService.getU9CUserInfo(user);
            if(u9c == null){
                addUserU9C(getToken(),user);
            }else{
                if(!user.getDeptId().equals(u9c.getDeptId())){
                    u9CService.updateU9CUserInfo(user);
                }
            }
        }
    }
    public String getToken() throws Exception {
        String param = "clientid=XYBRAPI&clientsecret=30d0c9b957ec44fdaba6367a74748295";
        log.info("【调用U9C接口获取授权码信息】,请求参数：{}",param);
        String result = HttpUtils.sendGet(url + "OAuth2/GetAuthorizeCode",param);
        log.info("【调用U9C接口获取授权码信息】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(StringUtils.format("调用U9C接口获取授权码信息失败。", jsonObject.get("ResMsg")));
        }
        String secret = jsonObject.get("Data").toString();
        param = "entCode=01&userCode=admin&orgCode=001&code=" + secret;
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
    public void addDeptU9C(String token, Department department) throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject u9cDeptJson = new JSONObject();
        JSONObject orgJson = new JSONObject();
        orgJson.put("ID", 0);
        orgJson.put("Code", "001");
        orgJson.put("Name", "西安星源博锐新能源技术有限公司");
        JSONObject workCalenJson = new JSONObject();
        workCalenJson.put("Code", "001");
        JSONObject effectiveJson = new JSONObject();
        effectiveJson.put("IsEffective", "1");
        effectiveJson.put("EffectiveDate", "2024-01-01");
        effectiveJson.put("DisableDate", "9999-01-01");
        JSONObject parentNodeJson = new JSONObject();
        parentNodeJson.put("Code", department.getParentU9cCode());
        u9cDeptJson.put("Org",orgJson);
        u9cDeptJson.put("WorkCalendar",workCalenJson);
        u9cDeptJson.put("Effective",effectiveJson);
        u9cDeptJson.put("ParentNode",parentNodeJson);
        u9cDeptJson.put("Code",department.getU9cCode());
        u9cDeptJson.put("Name",department.getDeptName());
        u9cDeptJson.put("Level",department.getLevel());
        jsonArray.add(u9cDeptJson);
        String param = jsonArray.toJSONString();
        log.info("【调用U9C接口新增部门信息】,请求参数：{}",param);
        HttpRequest request = HttpRequest.post(url + "Department/Create").header("token",token);
        HttpResponse response = request.body(param).execute();
        String result = response.body();
        log.info("【调用U9C接口新增部门信息】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(StringUtils.format("调用U9C接口新增部门信息失败。", jsonObject.get("ResMsg")));
        }
        JSONArray deptArr = jsonObject.getJSONArray("Data");
        if(deptArr.size() > 0){
            JSONObject o = deptArr.getJSONObject(0);
            department.setU9cCode(o.getString("m_code"));
            bpmService.updateDeptU9CCode(department);
        }else{
            throw new Exception(StringUtils.format("调用U9C接口新增部门信息失败。", jsonObject.get("ResMsg")));
        }
    }
    public void addUserU9C(String token, User user) throws Exception {
        JSONArray jsonArray = new JSONArray();
        JSONObject u9cUserJson = new JSONObject();
        JSONArray operatorJsonArray = new JSONArray();
        JSONObject operatorJson = new JSONObject();
        operatorJson.put("OperatorType",12);
        operatorJson.put("OperateType",0);
        operatorJsonArray.add(operatorJson);
        u9cUserJson.put("OperatorLine",operatorJsonArray);
        u9cUserJson.put("Org_Code", "001");
        u9cUserJson.put("Effective_DisableDate", "9999-01-01");
        u9cUserJson.put("Effective_EffectiveDate", "2024-01-01");
        u9cUserJson.put("Effective_IsEffective", true);
        u9cUserJson.put("OtherID", "0");
        u9cUserJson.put("Dept_Code",user.getDeptId());
        u9cUserJson.put("Code",user.getU9cCode());
        u9cUserJson.put("Name",user.getName());
        jsonArray.add(u9cUserJson);
        String param = jsonArray.toJSONString();
        log.info("【调用U9C接口新增业务员信息】,请求参数：{}",param);
        HttpRequest request = HttpRequest.post(url + "Operator/Create").header("token",token);
        HttpResponse response = request.body(param).execute();
        String result = response.body();
        log.info("【调用U9C接口新增业务员信息】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(StringUtils.format("调用U9C接口新增业务员信息失败。", jsonObject.get("ResMsg")));
        }
        JSONArray deptArr = jsonObject.getJSONArray("Data");
        if(deptArr.size() > 0){
            log.info("【调用U9C接口新增业务员信息】,返回结果：{}",result);
        }else{
            throw new Exception(StringUtils.format("调用U9C接口新增业务员信息失败。", jsonObject.get("ResMsg")));
        }
    }
}
