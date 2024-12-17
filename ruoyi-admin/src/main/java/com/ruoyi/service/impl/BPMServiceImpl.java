package com.ruoyi.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.domain.*;
import com.ruoyi.mapper.BPMMapper;
import com.ruoyi.mapper.U9CMapper;
import com.ruoyi.report.domain.cockpit.JiangBneMuBiao;
import com.ruoyi.service.BPMSalveDataSourceService;
import com.ruoyi.service.BPMService;
import com.ruoyi.service.U9CService;
import com.ruoyi.task.U9COrgTask;
import com.ruoyi.u9c.domain.POLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@DataSource(value = DataSourceType.SLAVE)
@Service
public class BPMServiceImpl implements BPMService {
    private static final Logger log = LoggerFactory.getLogger(BPMServiceImpl.class);
    private static final String url = "http://120.46.188.100/u9c/webapi/";
    @Autowired
    BPMMapper bpmMapper;
    @Autowired
    U9CMapper u9CMapper;
    @Autowired
    U9CService u9CService;
    @Autowired
    BPMSalveDataSourceService bpmSalveDataSourceService;
    @Override
    public List<Department> getDepartList(int level) {
        return bpmMapper.getDepartList(level);
    }

    @Override
    public int updateDeptU9CCode(Department department) {
        return bpmMapper.updateDeptU9CCode(department);
    }

    @Override
    public int updateUserInfoDeptU9CCode(List<User> list) {
        return bpmMapper.updateUserInfoDeptU9CCode(list);
    }

    @Override
    public List<User> getUserList() {
        return bpmMapper.getUserList();
    }

    @Override
    public int insertFixedFiled(List<FixedFiled> list) {
        bpmMapper.deleteFixedFiled();
        return bpmMapper.insertFixedFiled(list);
    }

    @Override
    public int insertSupplier(List<Supplier> list) {
        bpmMapper.deleteSupplier();
        return bpmMapper.insertSupplier(list);
    }

    @Override
    public JSONObject getPOLine(List<String> list,List<String> idsList,String PurDeptCode,String PurOperCode) {
        JSONObject result = new JSONObject();
        List<POLine> poList = bpmMapper.getPOLine(list,idsList);
        List<String> projectList = bpmMapper.getProject(list,idsList);
        List<String> supplierList = bpmMapper.getSupplier(list,idsList);
        List<String> caigouList = bpmMapper.getCaiGouType(list,idsList);
        for(String projectCode : projectList) {
            List<POLine> proJectPOLineList = poList.stream().filter(item -> projectCode.equals(item.getProjectCode())).collect(Collectors.toList());
            for(String supplier : supplierList){
                List<POLine> supplierPOLineList = proJectPOLineList.stream().filter(item -> supplier.equals(item.getSupplierCode())).collect(Collectors.toList());
                for(String caiGouType : caigouList){
                    JSONArray POJsonArray = new JSONArray();
                    JSONObject POJson = new JSONObject();
                    List<POLine> caiGouTypePOLineList = supplierPOLineList.stream().filter(item -> caiGouType.equals(item.getCaiGouType())).collect(Collectors.toList());
                    POJson.put("ID",0);
                    POJson.put("SubType",0);
                    POJson.put("DocumentType","PO01");
                    POJson.put("BizType",316);
                    POJson.put("BusinessDate",DateUtils.dateTimeNow("YYYY-MM-dd"));
                    JSONObject SupplierJson = new JSONObject();
                    SupplierJson.put("Code", supplier);
                    JSONObject PurOperJson = new JSONObject();
                    PurOperJson.put("m_code", PurOperCode);
                    JSONObject PurDeptJson = new JSONObject();
                    PurDeptJson.put("m_code", PurDeptCode);
                    POJson.put("Supplier",SupplierJson);
                    POJson.put("PurOper",PurOperJson);
                    POJson.put("PurDept",PurDeptJson);
                    POJson.put("Memo","BPM");
                    JSONArray POLineDTOList = new JSONArray();
                    JSONObject DescFlexFieldJson = new JSONObject();
                    String serializeNo = "";
                    List<String> serializeNoList = new ArrayList<>();
                    String shipAdress = "";
                    List<String> shipAdressList = new ArrayList<>();
                    int i = 0;
                    for (POLine poLine : caiGouTypePOLineList) {
                        i++;
                        JSONObject POLineDTOJson = new JSONObject();
                        JSONObject ItemJson = new JSONObject();
                        JSONObject TaxScheduleJson = new JSONObject();
                        ItemJson.put("m_code",poLine.getItemInfoCode());
                        POLineDTOJson.put("ItemInfo",ItemJson);
                        poLine.setDocLineNo(10*i);
                        POLineDTOJson.put("DocLineNo",poLine.getDocLineNo());
                        POLineDTOJson.put("ReqQtyTU",poLine.getReqQtyTU());
                        POLineDTOJson.put("SupplierConfirmQtyTU",poLine.getReqQtyTU());
//                        POLineDTOJson.put("FinallyPriceTC",poLine.getFinallyPriceTC());
                        POLineDTOJson.put("FinallyPriceTC",0.19);
                        POLineDTOJson.put("DeliveryDate",poLine.getDeliveryDate());
                        TaxScheduleJson.put("m_code","Y0Z2");
                        POLineDTOJson.put("TaxSchedule",TaxScheduleJson);

                        if(!serializeNoList.contains(poLine.getSerializeNo())){
                            serializeNoList.add(poLine.getSerializeNo());
                            serializeNo = serializeNo + poLine.getSerializeNo() + ";";
                        }
                        if(!shipAdressList.contains(poLine.getShipAdress())){
                            shipAdressList.add(poLine.getShipAdress());
                            shipAdress = shipAdress + poLine.getShipAdress() + ";";
                        }
                        POLineDTOList.add(POLineDTOJson);
                    }
                    DescFlexFieldJson.put("PubDescSeg11",shipAdress);
                    DescFlexFieldJson.put("PrivateDescSeg1",serializeNo);
                    POJson.put("DescFlexField",DescFlexFieldJson);
                    POJson.put("POLineDTOList",POLineDTOList);
                    if(POLineDTOList.size() > 0){
                        POJsonArray.add(POJson);
                        try {
                            //推送
                            JSONObject resultJson = pushU9CPOLine(POJsonArray);
                            JSONArray dataJsons = (JSONArray) resultJson.get("Data");
                            JSONObject dataJson = JSON.parseObject(dataJsons.getString(0));
                            boolean flag = dataJson.getBoolean("IsSucess");
                            if(!flag){
                                result.put("code","500");
                                result.put("MSG",dataJson.get(""));
                                return result;
                            }
                            String orderCode = dataJson.getString("Code");
                            String newOrdeCode = orderCode;
                            //更新合同编号
                            for (POLine poLine : supplierPOLineList) {
                                poLine.setOrderCode(orderCode);
                            }
                            //查看采购用途类型
                            if("EC小批量验证".equals(caiGouType)){
                                //更改new orderCode
                                newOrdeCode = orderCode.replace("CG","EC");
                                bpmSalveDataSourceService.updateCaiGouDetail(supplierPOLineList,list,newOrdeCode,supplier);
                                //更改U9C orderCode ——> new orderCode
                                u9CService.updateOrderCode(newOrdeCode,orderCode);
                            }else if("试制加工需求".equals(caiGouType)){
                                //更改new orderCode
                                newOrdeCode = orderCode.replace("CG","YF");
                                bpmSalveDataSourceService.updateCaiGouDetail(supplierPOLineList,list,newOrdeCode,supplier);
                                //更改U9C orderCode ——> new orderCode
                                u9CService.updateOrderCode(newOrdeCode,orderCode);
                            }else{
                                bpmSalveDataSourceService.updateCaiGouDetail(supplierPOLineList,list,newOrdeCode,supplier);
                            }

                            for (POLine poLine : supplierPOLineList) {
                                u9CService.updateLotCode(poLine.getLotCode(), newOrdeCode, poLine.getItemInfoCode(),poLine.getDocLineNo(),poLine.getDeliveryDate());
                            }
                            JSONArray subJsonArr = new JSONArray();
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("Code",newOrdeCode);
                            subJsonArr.add(jsonObject);
                            //submitU9CPOLine(subJsonArr);
                            result.put("code","200");
                            result.put("MSG","成功生成U9标准采购！");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<ArriveQty> getCaiGouDetail() {
        return bpmMapper.getCaiGouDetail();
    }

    @Override
    public int updateArriveQty(ArriveQty arriveQty) {
        return bpmMapper.updateArriveQty(arriveQty);
    }

    public JSONObject pushU9CPOLine(JSONArray POJsonArray) throws Exception {
        String param = JSONUtil.toJsonStr(POJsonArray);
        String token = getToken();
        log.info("【调用U9C接口新增标准采购】,请求参数：{}",param);
        HttpRequest request = HttpRequest.post(url + "PurchaseOrder/Create").header("token",token);
        HttpResponse response = request.body(param).execute();
        String result = response.body();
        log.info("【调用U9C接口新增标准采购】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(StringUtils.format("调用U9C接口新增标准采购失败。", jsonObject.get("ResMsg")));
        }
        JSONArray deptArr = jsonObject.getJSONArray("Data");
        if(deptArr.size() > 0){
            log.info("【调用U9C接口新增标准采购】,返回结果：{}",result);
        }else{
            throw new Exception(StringUtils.format("调用U9C接口新增标准采购失败。", jsonObject.get("ResMsg")));
        }
        return jsonObject;
    }
    public JSONObject submitU9CPOLine(JSONArray POCodeJson) throws Exception {
        String param = JSONUtil.toJsonStr(POCodeJson);
        String token = getToken();
        log.info("【调用U9C接口提交标准采购】,请求参数：{}",param);
        HttpRequest request = HttpRequest.post(url + "PurchaseOrder/Submit").header("token",token);
        HttpResponse response = request.body(param).execute();
        String result = response.body();
        log.info("【调用U9C接口提交标准采购】,返回结果：{}",result);
        JSONObject jsonObject = JSON.parseObject(result);
        if(StringUtils.isEmpty(result) && !(boolean)jsonObject.get("Success")){
            throw new Exception(StringUtils.format("调用U9C接口提交标准采购失败。", jsonObject.get("ResMsg")));
        }
        JSONArray deptArr = jsonObject.getJSONArray("Data");
        if(deptArr.size() > 0){
            log.info("【调用U9C接口提交标准采购】,返回结果：{}",result);
        }else{
            throw new Exception(StringUtils.format("调用U9C接口提交标准采购失败。", jsonObject.get("ResMsg")));
        }
        return jsonObject;
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
}
