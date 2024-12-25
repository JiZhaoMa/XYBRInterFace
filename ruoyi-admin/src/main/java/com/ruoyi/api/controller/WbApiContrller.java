package com.ruoyi.api.controller;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.api.domian.*;
import com.ruoyi.api.service.ApiService;
import com.ruoyi.api.service.ApiU9CService;
import com.ruoyi.api.service.IOrderPlatInfoService;
import com.ruoyi.api.service.PlatCacheService;
import com.ruoyi.api.util.Mail;
import com.ruoyi.api.util.TokenValidation;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.http.HttpUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/XYBR")
@RestController
public class WbApiContrller {

    private Logger logger = LoggerFactory.getLogger(WbApiContrller.class);
    private static final String url = "http://120.46.188.100/u9c/webapi/";
    private static final String recivmentUrl = "Receivement/CreateRcvBySrcPO";
    @Autowired
    IOrderPlatInfoService platInfoService;
    @Autowired
    PlatCacheService cacheService;
    @Autowired
    ApiU9CService apiU9CService;
    @Autowired
    ApiService apiService;
    @Autowired
    Mail mail;
    @Value("${mail.toUser}")
    private  String to;
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
            cacheService.firstCachePlatInfo(appKey,platInfo);
            logger.info("【第三方对接平台通过appKey换取token接口】响应结果：{}", JSON.toJSONString(AjaxResult.success("请求成功",token)));
            return AjaxResult.success("请求成功",token);
        }catch (Exception e){
            logger.error("【第三方对接平台通过appKey换取token接口】系统异常：{}", JSON.toJSONString(AjaxResult.error(e.getMessage())));
            return AjaxResult.error(e.getMessage());
        }
    }


    /**
     * 原材料入库
     * @param
     * @return
     */
    @PostMapping("/receive/material")
    @TokenValidation
    public AjaxResult handleMaterial(@RequestBody JSONArray param) throws Exception {
        logger.info("【第三方对接平台调用原材料入库接口】请求参数：{}",param);
        try{
            AjaxResult ajaxResult = validationParam("material",param);
            if((int)ajaxResult.get("code") != 0){
                return ajaxResult;
            }
            JSONObject resultJson = new JSONObject();
            for(int i=0; i<param.size(); i++){
                JSONObject jsonObject = param.getJSONObject(i);
                String ReciveDate = jsonObject.getString("ReciveDate");
                String ItemCode = jsonObject.getString("ItemCode");
                String Suppier = jsonObject.getString("Suppier");
                String Fact = jsonObject.getString("Fact");
                int ReciveNum = jsonObject.getIntValue("ReciveNum");
                int shenYuReciveNum = ReciveNum;
                //用物料编码，供应商名称，收货数量 匹配采购订单
                Material material = new Material();
                material.setItemCode(ItemCode);
                material.setSuppier(Suppier);
                material.setReciveNum(ReciveNum);
                List<Material> materialList = apiU9CService.getMaterial(material);
                //如果没有匹配到采购订单，就去掉收货数量再次进行匹配
                if(materialList.isEmpty()){
                    material.setReciveNum(0);
                    materialList = apiU9CService.getMaterial(material);
                }
                if(!materialList.isEmpty()){
                    boolean flag = true;
                    for(Material m : materialList){
                        if(flag){
                            if(m.getReqQtyTU() > m.getRcvQtyCU()){
                                m.setReciveNum(m.getReqQtyTU() - m.getRcvQtyCU());
                                JSONArray jsonArray = new JSONArray();
                                JSONArray dtoJsonArray = new JSONArray();
                                JSONObject materialJson = new JSONObject();
                                JSONObject dtoJson = new JSONObject();
                                JSONObject rlInfoJson = new JSONObject();
                                JSONObject whJson = new JSONObject();
                                JSONObject WhMan = new JSONObject();
                                WhMan.put("m_code","majuan");
                                whJson.put("m_code","03");
                                rlInfoJson.put("Wh",whJson);
                                rlInfoJson.put("WhMan",WhMan);
                                rlInfoJson.put("StorageType",4);
                                rlInfoJson.put("ConfirmDate",ReciveDate);
                                dtoJson.put("BusinessDate",ReciveDate);
                                if(materialList.size() == 1){
                                    dtoJson.put("Amount1",ReciveNum);
                                    dtoJson.put("RcvQtyPU",ReciveNum);
                                    shenYuReciveNum -= ReciveNum;
                                }else{
                                    if(shenYuReciveNum > m.getReciveNum()){
                                        dtoJson.put("Amount1",m.getReciveNum());
                                        dtoJson.put("RcvQtyPU",m.getReciveNum());
                                        shenYuReciveNum -= m.getReciveNum();
                                    }else if(shenYuReciveNum == m.getReciveNum()){
                                        dtoJson.put("Amount1",m.getReciveNum());
                                        dtoJson.put("RcvQtyPU",m.getReciveNum());
                                        shenYuReciveNum = 0;
                                    }else{
                                        dtoJson.put("Amount1",shenYuReciveNum);
                                        dtoJson.put("RcvQtyPU",shenYuReciveNum);
                                        shenYuReciveNum = 0;
                                    }
                                }
                                dtoJson.put("PONo",m.getDocNo());
                                dtoJson.put("POLineNo",m.getDocLineNo());
                                dtoJson.put("rlInfo",rlInfoJson);
                                dtoJson.put("ConfirmDate",ReciveDate);
                                dtoJsonArray.add(dtoJson);
                                materialJson.put("potorcvDTOS",dtoJsonArray);
                                materialJson.put("IsApproved",false);
                                materialJson.put("DocStatus",0);
                                materialJson.put("Memo","代工厂通过调用接口，直接进行入库操作");
                                materialJson.put("RcvDocTypeCode","RCV01");
                                jsonArray.add(materialJson);
                                resultJson = hadelU9cApi(recivmentUrl,jsonArray.toJSONString(),"原材料入库");
                                String resultMsg = "Sucess";
                                if(!(boolean)resultJson.get("Success")){
                                    mail.sendMail(to,"原材料入库","物料：" + ItemCode + ";供应商：" + Suppier + "入库数量: " + ReciveNum + "</br>入库失败：" + resultJson.get("ResMsg").toString());
                                    resultMsg = resultJson.get("ResMsg").toString();
                                }else{
                                    JSONArray dataArr = (JSONArray)resultJson.get("Data");
                                    JSONObject object = dataArr.getJSONObject(0);
                                    if(!(boolean)object.get("IsSucess")){
                                        mail.sendMail(to,"原材料入库","物料：" + ItemCode + ";供应商：" + Suppier + "入库数量: " + ReciveNum + "</br>入库失败：" + object.get("ErrorMsg").toString());
                                        resultMsg = object.get("ErrorMsg").toString();
                                    }else{
                                        resultMsg = resultJson.get("Data").toString();
                                    }
                                }
                                AjaxResult ajax = insertRecivmentLog(ItemCode, Suppier, ReciveDate, ReciveNum, (Integer) dtoJson.get("Amount1"), dtoJson.get("PONo").toString(), Integer.parseInt(dtoJson.get("POLineNo").toString()), resultMsg,Fact);
                                if((int)ajax.get("code") != 0){
                                    return ajaxResult;
                                }
                                if(shenYuReciveNum <= 0){
                                    flag = false;
                                }

                            }
                        }
                    }
                    if(shenYuReciveNum > 0){
                        //入库数量小于供应商发货数量
                        //954615556 物料供应商发货100，剩余10未入库，请确认！
                        String content = ItemCode + "(" + Suppier + ")：" ;
                        mail.sendMail(to,"原材料入库",content + "</br>入库数量小于供应商发货数量，请及时确认！");
                    }
                }else{
                    //954615556(供应商)  没有匹配到相应的采购订单，请确认！
                    String content = ItemCode + "(" + Suppier + ")：";
                    mail.sendMail(to,"原材料入库",content + "</br>没有匹配到相应的采购订单，请及时确认！");
                }
            }
        }catch (Exception e){
            return AjaxResult.error(e.getMessage(),null);
        }
        return AjaxResult.success("原材料入库接口调用成功！",null);
    }
    @PostMapping("/receive/product")
    @TokenValidation
    public AjaxResult handleProduct(@RequestBody JSONArray param) {
        logger.info("【第三方对接平台调用产品入库接口】请求参数：{}",param);
        try{
            AjaxResult ajaxResult = validationParam("product",param);
            if((int)ajaxResult.get("code") != 0){
                return ajaxResult;
            }
            JSONObject resultJson = new JSONObject();
            for(int i=0; i<param.size(); i++){
                JSONObject jsonObject = param.getJSONObject(i);
                String ReciveDate = jsonObject.getString("ReciveDate");
                String POStr = jsonObject.getString("PO");
                String PO = POStr.substring(0,19);
                int POLineNo = Integer.parseInt(POStr.substring(20,POStr.length()));
                String ItemCode = jsonObject.getString("ItemCode");
                String Fact = jsonObject.getString("Fact");
                int ReciveNum = jsonObject.getIntValue("ReciveNum");
                Product p = new Product();
                p.setFact(Fact);
                p.setPO(PO);
                p.setPOLineNo(POLineNo);
                p.setReciveNum(ReciveNum);
                p.setReciveDate(ReciveDate);
                p.setItemCode(ItemCode);

                JSONArray jsonArray = new JSONArray();
                JSONArray dtoJsonArray = new JSONArray();
                JSONObject materialJson = new JSONObject();
                JSONObject dtoJson = new JSONObject();
                JSONObject rlInfoJson = new JSONObject();
                JSONObject whJson = new JSONObject();
                JSONObject WhMan = new JSONObject();
                WhMan.put("m_code","majuan");
                whJson.put("m_code","01");
                rlInfoJson.put("Wh",whJson);
                rlInfoJson.put("WhMan",WhMan);
                rlInfoJson.put("StorageType",4);
                rlInfoJson.put("ConfirmDate",p.getReciveDate());
                dtoJson.put("BusinessDate",p.getReciveDate());
                dtoJson.put("Amount1",p.getReciveNum());
                dtoJson.put("RcvQtyPU",p.getReciveNum());
                dtoJson.put("PONo",p.getPO());
                dtoJson.put("POLineNo",p.getPOLineNo());
                dtoJson.put("rlInfo",rlInfoJson);
                dtoJson.put("ConfirmDate",p.getReciveDate());
                dtoJsonArray.add(dtoJson);
                materialJson.put("potorcvDTOS",dtoJsonArray);
                materialJson.put("IsApproved",false);
                materialJson.put("DocStatus",0);
                materialJson.put("Memo","代工厂通过调用接口，直接进行入库操作");
                materialJson.put("RcvDocTypeCode","RCV11");
                jsonArray.add(materialJson);
                resultJson = hadelU9cApi(recivmentUrl,jsonArray.toJSONString(),"成品入库");
                String resultMsg = "";
                if(!(boolean)resultJson.get("Success")){
                    mail.sendMail(to,"成品入库","生产订单：" + POStr + "入库数量: " + ReciveNum + "</br>入库失败：" + resultJson.get("ResMsg").toString());
                    resultMsg = resultJson.get("ResMsg").toString();
                }else{
                    JSONArray dataArr = (JSONArray)resultJson.get("Data");
                    JSONObject object = dataArr.getJSONObject(0);
                    if(!(boolean)object.get("IsSucess")){
                        mail.sendMail(to,"成品入库","生产订单：" + POStr + "入库数量: " + ReciveNum + "</br>入库失败：" + object.get("ErrorMsg").toString());
                        resultMsg = object.get("ErrorMsg").toString();
                    }else{
                        resultMsg = resultJson.get("Data").toString();
                    }
                }
                String Supplier = "星源";
                AjaxResult ajax = insertRecivmentLog(ItemCode, Supplier, ReciveDate, ReciveNum, ReciveNum, PO, POLineNo, resultMsg,Fact);
                if((int)ajax.get("code") != 0){
                    return ajaxResult;
                }
            }
        }catch (Exception e){
            return AjaxResult.error(e.toString(),null);
        }
        return AjaxResult.success("成品入库接口调用成功！",null);
    }


    public JSONObject hadelU9cApi(String apiUrl,String param,String apiType) throws Exception {
        String token = getToken();
        logger.info("【调用U9C接口" +apiType+ "信息】,请求参数：{}",param);
        HttpRequest request = HttpRequest.post(url + apiUrl).header("token",token);
        HttpResponse response = request.body(param).execute();
        String result = response.body();
        logger.info("【调用U9C接口" +apiType+ "信息】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(com.ruoyi.common.utils.StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(com.ruoyi.common.utils.StringUtils.format("调用U9C接口" +apiType+ "信息失败。", jsonObject.get("ResMsg")));
        }
        return jsonObject;
    }
    public String getToken() throws Exception {
        String param = "clientid=XYBRAPI&clientsecret=30d0c9b957ec44fdaba6367a74748295";
        logger.info("【调用U9C接口获取授权码信息】,请求参数：{}",param);
        String result = HttpUtils.sendGet(url + "OAuth2/GetAuthorizeCode",param);
        logger.info("【调用U9C接口获取授权码信息】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(com.ruoyi.common.utils.StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(com.ruoyi.common.utils.StringUtils.format("调用U9C接口获取授权码信息失败。", jsonObject.get("ResMsg")));
        }
        String secret = jsonObject.get("Data").toString();
        param = "entCode=01&userCode=admin&orgCode=001&code=" + secret;
        logger.info("【调用U9C接口获取信息】,请求参数：{}",param);
        result = HttpUtils.sendGet(url + "OAuth2/Login",param);
        logger.info("【调用U9C接口获取token信息】,返回结果：{}",result);
        jsonObject = JSON.parseObject(result);
        if(com.ruoyi.common.utils.StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(com.ruoyi.common.utils.StringUtils.format("调用U9C接口获取token信息失败。", jsonObject.get("errmsg")));
        }
        String token = jsonObject.get("Data").toString();
        return token;
    }
    public AjaxResult validationParam(String apiType,JSONArray param){
        if(param.isEmpty()){
            return AjaxResult.error("传入的参数为空！", null);
        }
        if("material".equals(apiType)){
            for(int i=0; i<param.size(); i++) {
                JSONObject jsonObject = param.getJSONObject(i);
                String ReciveDate = jsonObject.getString("ReciveDate");
                String ItemCode = jsonObject.getString("ItemCode");
                String Suppier = jsonObject.getString("Suppier");
                String Fact = jsonObject.getString("Fact");
                int ReciveNum = jsonObject.getIntValue("ReciveNum");
                if (ReciveDate.isEmpty()) {
                    return AjaxResult.error("传入的ReciveDate参数为空！", null);
                }
                if (Suppier.isEmpty()) {
                    return AjaxResult.error("传入的Suppier参数为空！", null);
                }
                if (ItemCode.isEmpty()) {
                    return AjaxResult.error("传入的ItemCode参数为空！", null);
                }
                if (Fact.isEmpty()) {
                    return AjaxResult.error("传入的Fact参数为空！", null);
                }
                if (ReciveNum == 0) {
                    return AjaxResult.error("传入的ReciveNum参数为空！", null);
                }
            }
        }
        if("product".equals(apiType)){
            for(int i=0; i<param.size(); i++) {
                JSONObject jsonObject = param.getJSONObject(i);
                String ReciveDate = jsonObject.getString("ReciveDate");
                String POStr = jsonObject.getString("PO");
                try{
                    String PO = POStr.substring(0, 19);
                    int POLineNo = Integer.parseInt(POStr.substring(20, POStr.length()));
                }catch (Exception e){
                    return AjaxResult.error("生产订单号:" +POStr+ "的格式不正确，请确认！", null);
                }

                String ItemCode = jsonObject.getString("ItemCode");
                String Fact = jsonObject.getString("Fact");
                int ReciveNum = jsonObject.getIntValue("ReciveNum");
                if (ReciveDate.isEmpty()) {
                    return AjaxResult.error("传入的ReciveDate参数为空！", null);
                }
                if (POStr.isEmpty()) {
                    return AjaxResult.error("传入的POStr参数为空！", null);
                }
                if (ItemCode.isEmpty()) {
                    return AjaxResult.error("传入的ItemCode参数为空！", null);
                }
                if (Fact.isEmpty()) {
                    return AjaxResult.error("传入的Fact参数为空！", null);
                }
                if (ReciveNum == 0) {
                    return AjaxResult.error("传入的ReciveNum参数为空！", null);
                }
            }
        }
        return AjaxResult.success("参数校验通过！", null);
    }
    public AjaxResult insertRecivmentLog(String ItemCode,String Suppier,String ReciveDate,int ReciveNum,int ActRecivmentNum,String PONo,int POLineNo,String Result,String Fact){
        try{
            RecivmentLog recivmentLog = new RecivmentLog();
            recivmentLog.setItemCode(ItemCode);
            recivmentLog.setSuppier(Suppier);
            recivmentLog.setReciveDate(ReciveDate);
            recivmentLog.setReciveNum(ReciveNum);
            recivmentLog.setActRecivmentNum(ActRecivmentNum);
            recivmentLog.setPONo(PONo);
            recivmentLog.setPOLineNo(POLineNo);
            recivmentLog.setResult(Result);
            recivmentLog.setFact(Fact);
            apiService.insertRecivmentLog(recivmentLog);
        }catch (Exception e){
            return AjaxResult.error(e.toString(),null);
        }
        return AjaxResult.success("收货日志记录成功！" ,null);
    }
}
