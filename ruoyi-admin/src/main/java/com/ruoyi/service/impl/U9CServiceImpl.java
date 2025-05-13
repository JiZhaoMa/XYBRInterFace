package com.ruoyi.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.domain.*;
import com.ruoyi.mapper.U9CMapper;
import com.ruoyi.service.U9CService;
import com.ruoyi.u9c.domain.ItemInfo;
import com.ruoyi.u9c.domain.ItemLotCodeInfo;
import com.ruoyi.u9c.service.ItemInfoOfBpmService;
import com.ruoyi.u9c.service.ItemLotCodeService;
import com.ruoyi.u9c.service.ItemLotCodeU9CService;
import com.ruoyi.u9c.util.U9CUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DataSource(value = DataSourceType.U9C)
@Service
public class U9CServiceImpl implements U9CService {
    private static final Logger log = LoggerFactory.getLogger(U9CServiceImpl.class);
    @Autowired
    U9CMapper u9CMapper;
    @Autowired
    ItemLotCodeService itemLotCodeService;
    @Autowired
    ItemInfoOfBpmService itemInfoOfBpmService;
    @Autowired
    U9CUtil u9CUtil;
    @Autowired
    ItemLotCodeU9CService itemLotCodeU9CService;
    @Override
    public List<Department> getU9CDeptByName(String name) {
        return u9CMapper.getU9CDeptByName(name);
    }
    @Override
    public Department getDepartCode(Department d) {
        return u9CMapper.getDepartCode(d);
    }

    @Override
    public List<User> getU9CUserInfo(User user) {
        return u9CMapper.getU9CUserInfo(user);
    }

    @Override
    public int updateU9CUserInfo(User user) {
        return u9CMapper.updateU9CUserInfo(user);
    }

    @Override
    public List<FixedFiled> getU9CFixedFiled() {
        return u9CMapper.getU9CFixedFiled();
    }

    @Override
    public List<Supplier> getU9CSupplier() {
        return u9CMapper.getU9CSupplier();
    }

    @Override
    public String getAssetCode(String assetCard) {
        return u9CMapper.getAssetCode(assetCard);
    }

    @Override
    public int updateOrderCode(String newOrderCode, String orderCode) {
        return u9CMapper.updateOrderCode(newOrderCode,orderCode);
    }

    @Override
    public int updateLotCode(String lotCode, String orderCode, String itemCode,int docLineNo,String deliveryDate) {
        return u9CMapper.updateLotCode(lotCode,orderCode,itemCode,docLineNo,deliveryDate);
    }

    @Override
    public ArriveQty selectArriveQty(ArriveQty arriveQty) {
        return u9CMapper.selectArriveQty(arriveQty);
    }

    @Override
    public ItemInfo selectPriceInfoOfXyPurch(ItemInfo itemInfo) {
        return u9CMapper.selectPriceInfoOfXyPurch(itemInfo);
    }

    @Override
    public ItemInfo selectPriceInfoOfProxyPurch(ItemInfo itemInfo) {
        return u9CMapper.selectPriceInfoOfProxyPurch(itemInfo);
    }

    @Override
    public ItemInfo selectPriceInfoOfRdmStage(ItemInfo itemInfo) {
        return u9CMapper.selectPriceInfoOfRdmStage(itemInfo);
    }

    @Override
    public AjaxResult synItemOf(ItemInfo itemInfo) throws Exception {
        log.info("调用U9C料品新增接口");
        itemInfo = itemInfoOfBpmService.getItemList(itemInfo);
        String nextSupplyDate = DateUtils.parseDateToStr("YYYY-MM-dd",DateUtils.getNowDate()); //下次补货日 当前日期
        JSONObject mainItemCategoryJson = new JSONObject();
        mainItemCategoryJson.put("Code",itemInfo.getXiaoLeiCode()); //器件小类编码
        JSONObject orgJson = new JSONObject();
        orgJson.put("Code","001"); //组织
        JSONObject inventoryUOMJson = new JSONObject();
        switch (itemInfo.getCategoryName()){
            case "PCS":
                inventoryUOMJson.put("Code","01");
                break;
            case "ML":
                inventoryUOMJson.put("Code","02");
                break;
            case "m":
                inventoryUOMJson.put("Code","03");
                break;
            case "cm":
                inventoryUOMJson.put("Code","04");
                break;
            case "mm":
                inventoryUOMJson.put("Code","05");
                break;
            case "kg":
                inventoryUOMJson.put("Code","06");
                break;
            case "套":
                inventoryUOMJson.put("Code","07");
                break;
            case "台":
                inventoryUOMJson.put("Code","08");
                break;
            case "g":
                inventoryUOMJson.put("Code","09");
                break;
            default:
                inventoryUOMJson.put("Code","01");
                break;
        }
        //库存单位Code  01pcs 02ML 03M 04CM 05MM 06KG 07套 08台 09g
        JSONObject inventoryInfoJson = new JSONObject();
        inventoryInfoJson.put("ReserveMode", -1); //预留方式
        inventoryInfoJson.put("SupplyMethod",-1); //补货方法
        inventoryInfoJson.put("InventoryPlanningMethod",4); //规划方法
        inventoryInfoJson.put("TurnOverRate",1); //周转率
        inventoryInfoJson.put("FixPeriod",1); //固定期间
        inventoryInfoJson.put("ReorderQty",1); //再订货量
        inventoryInfoJson.put("NextSupplyDate", nextSupplyDate); //当前日期
        JSONObject lotParamJson = new JSONObject();
        lotParamJson.put("Code","001"); //
        inventoryInfoJson.put("LotParam",lotParamJson); //批号参数
        JSONObject mrpInfoJson = new JSONObject();
        mrpInfoJson.put("MRPPlanningType",1); //
        mrpInfoJson.put("ForecastContorlType",1); //
        mrpInfoJson.put("IsTraceRequirement",true); //
        JSONObject mfgInfoJson = new JSONObject();
        mfgInfoJson.put("DesignationRule",1);  //番号对比规则
        mfgInfoJson.put("BuildShrinkageRate",1); //
        mfgInfoJson.put("IsOutputControlFlag",true); //
        JSONObject costCurrencyJson = new JSONObject();
        costCurrencyJson.put("Code",1); //
        JSONObject descFlexFieldJson = new JSONObject();
        descFlexFieldJson.put("PrivateDescSeg1",itemInfo.getRohs()); //
        descFlexFieldJson.put("PubDescSeg2",itemInfo.getItemStatus()); //
        descFlexFieldJson.put("PubDescSeg3",itemInfo.getItemLevel()); //
        descFlexFieldJson.put("PubDescSeg8",itemInfo.getReach()); //

        JSONObject purchInfoJson = new JSONObject();
        purchInfoJson.put("PriceSource", 2); //取价来源
        purchInfoJson.put("QuotaSupplier",1); //配额供应商
        purchInfoJson.put("PurchaseQuotaMode",1); //配额方式
        purchInfoJson.put("IsPUTradePathModify",true); //采购贸易路径可改
        purchInfoJson.put("IsPURtnTradePathModify",true); //采购退货贸易路径可改

        JSONObject itemDatasJson = new JSONObject();
        itemDatasJson.put("MainItemCategory",mainItemCategoryJson);
        itemDatasJson.put("Org",orgJson);
        itemDatasJson.put("InventoryUOM",inventoryUOMJson);
        itemDatasJson.put("InventoryInfo",inventoryInfoJson);
        itemDatasJson.put("PurchaseInfo",purchInfoJson);
        itemDatasJson.put("MrpInfo", mrpInfoJson);
        itemDatasJson.put("MfgInfo", mfgInfoJson);
        itemDatasJson.put("CostCurrency", costCurrencyJson);
        itemDatasJson.put("DescFlexField", descFlexFieldJson);
        itemDatasJson.put("Code",itemInfo.getCode());
        itemDatasJson.put("Name",itemInfo.getXiaoleiName());
        itemDatasJson.put("Description",itemInfo.getItemDesc());
        itemDatasJson.put("ItemFormAttribute",4);
        itemDatasJson.put("State",1);
        itemDatasJson.put("IsInventoryEnable",true);
        itemDatasJson.put("IsPurchaseEnable",true);
        itemDatasJson.put("IsSalesEnable",true);
        itemDatasJson.put("IsBuildEnable",true);
        itemDatasJson.put("IsOutsideOperationEnable",true);
        itemDatasJson.put("IsMRPEnable",true);
        itemDatasJson.put("IsBOMEnable",true);
        itemDatasJson.put("IsVarRatio",true);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(itemDatasJson);

        String param = jsonArray.toJSONString();
        JSONObject resultJson = u9CUtil.postU9CApi(param,"ItemMaster/Create","创建料品信息");
        boolean resultSuccess = (Boolean) resultJson.get("Success");
        if(resultSuccess){
            JSONArray dataArr = (JSONArray) resultJson.get("Data");
            JSONObject resultDataJson = dataArr.getJSONObject(0);
            boolean resultIsSuccess = (Boolean) resultDataJson.get("m_isSucess");
            if(resultIsSuccess){
                //新增批号主档
                try {
                    ItemLotCodeInfo itemLotCodeInfo = new ItemLotCodeInfo();
                    itemLotCodeInfo.setItemCode(itemInfo.getCode());
                    synItemOfLotCode(itemLotCodeInfo);
                    return AjaxResult.success("调用U9C料品新增接口完成！！！",itemInfo.getCode());
                }catch (Exception e){
                    return AjaxResult.error(e.toString());
                }
            }else{
                return AjaxResult.error(StringUtils.format("调用U9C接口新增料品信息失败:" +  resultDataJson.get("m_errorMsg")));
            }
        }else{
            return AjaxResult.error(StringUtils.format("调用U9C接口新增料品信息失败:" +  resultJson.get("ResMsg")));
        }
    }

    @Override
    public AjaxResult synItemOfLotCode(ItemLotCodeInfo itemLotCodeInfo) throws Exception {
        log.info("调用U9C批号主档新增接口");
        List<ItemLotCodeInfo> lotCodeList = itemLotCodeService.getItemLotCodeList(itemLotCodeInfo.getItemCode());
        //新增批号主档
        try {
            for(ItemLotCodeInfo lotCode : lotCodeList){
                insertLotCode(lotCode);
            }
            return AjaxResult.success("调用U9C料品新增接口完成！！！",itemLotCodeInfo.getItemCode());
        }catch (Exception e){
            return AjaxResult.error(e.toString());
        }
    }

    @Override
    public AjaxResult updateItemOf(ItemInfo itemInfo) throws Exception {
        AjaxResult itemResult = updateItemInfo(itemInfo);
        if((Integer)itemResult.get("code") == 0){
            ItemLotCodeInfo itemLotCodeInfo = new ItemLotCodeInfo();
            itemLotCodeInfo.setItemCode(itemInfo.getCode());
            return updateItemOfLotCode(itemLotCodeInfo);
        }
        return itemResult;
    }

    @Override
    public AjaxResult updateItemOfLotCode(ItemLotCodeInfo itemLotCodeInfo) throws Exception {
        List<ItemLotCodeInfo> lotCodeU9CList = itemLotCodeU9CService.getItemLotCodeList(itemLotCodeInfo.getItemCode());
        List<ItemLotCodeInfo> lotCodeBPMList = itemLotCodeService.getItemLotCodeList(itemLotCodeInfo.getItemCode());
        for(ItemLotCodeInfo lotCodeBPMInfo : lotCodeBPMList){
            int m = 0; //0 不变  1 U9C需要新增    2 U9C需要作废   3 U9C需要删除  4 U9C需要修改优选等级
            boolean flag = false;
            for(ItemLotCodeInfo lotCodeU9CInfo : lotCodeU9CList){
                if(lotCodeU9CInfo.getLotCode().equals(lotCodeBPMInfo.getLotCode())){
                    if(lotCodeU9CInfo.getPreLevel().equals(lotCodeBPMInfo.getPreLevel())){
                        m = 0;
                    }else{
                        m = 4;
                    }
                    flag = true;
                }
            }
            if(!flag){
                m = 1;
            }
            if(m == 1){
                insertLotCode(lotCodeBPMInfo);
            }else if(m == 4){
                //修改批号主档的优选等级
                itemLotCodeU9CService.updateLotCode(lotCodeBPMInfo);
            }
        }
        for(ItemLotCodeInfo lotCodeU9CInfo : lotCodeU9CList){
            int m = 0; //0 不变  1 U9C需要新增    2 U9C需要作废   3 U9C需要删除  4 U9C需要修改优选等级
            boolean flag = false;
            for(ItemLotCodeInfo lotCodeBPMInfo : lotCodeBPMList){
                if(lotCodeU9CInfo.getLotCode().equals(lotCodeBPMInfo.getLotCode())){
                    flag = true;
                }
            }
            if(!flag){
                if("1".equals(lotCodeU9CInfo.getIsUsed())){
                    m = 2;
                }else{
                    m = 3;
                }
            }
            if(m == 2){
                //修改批号主档失效时间
                itemLotCodeU9CService.updateLotCode(lotCodeU9CInfo);
            }else if(m == 3){
                //删除批号主档
                deleteLotCode(lotCodeU9CInfo);
            }
        }
        return AjaxResult.success("调用U9C修改批号主档信息接口成功:" +  itemLotCodeInfo.getLotCode());
    }

    @Override
    public List<Customer> getU9CCustomerInfo() {
        return u9CMapper.getU9CCustomerInfo();
    }

    public AjaxResult updateItemInfo(ItemInfo itemInfo) throws Exception {
        itemInfo = itemInfoOfBpmService.getItemList(itemInfo);
        JSONObject itemInfoJson = new JSONObject();
        itemInfoJson.put("Code",itemInfo.getCode());
        JSONArray attriJson = new JSONArray();

        JSONObject descJson = new JSONObject();
        descJson.put("AttributeName","Description");
        descJson.put("AttributeValue",itemInfo.getItemDesc());
        attriJson.add(descJson);

        JSONObject itemLevelJson = new JSONObject();
        itemLevelJson.put("AttributeName","DescFlexField.PubDescSeg3");
        itemLevelJson.put("AttributeValue",itemInfo.getItemLevel());
        attriJson.add(itemLevelJson);

        JSONObject rohsJson = new JSONObject();
        rohsJson.put("AttributeName","DescFlexField.PrivateDescSeg1");
        rohsJson.put("AttributeValue",itemInfo.getRohs());
        attriJson.add(rohsJson);

        JSONObject itemStatusJson = new JSONObject();
        itemStatusJson.put("AttributeName","DescFlexField.PubDescSeg2");
        itemStatusJson.put("AttributeValue",itemInfo.getItemStatus());
        attriJson.add(itemStatusJson);

        JSONObject reachJson = new JSONObject();
        reachJson.put("AttributeName","DescFlexField.PubDescSeg8");
        reachJson.put("AttributeValue",itemInfo.getReach());
        attriJson.add(reachJson);

        itemInfoJson.put("Attributes",attriJson);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(itemInfoJson);
        String param = jsonArray.toJSONString();
        JSONObject resultJson = u9CUtil.postU9CApi(param,"ItemMaster/Modify","修改料品信息");
        boolean resultSuccess = (Boolean) resultJson.get("Success");
        if(resultSuccess){
            JSONArray dataArr = (JSONArray) resultJson.get("Data");
            JSONObject resultDataJson = dataArr.getJSONObject(0);
            boolean resultIsSuccess = (Boolean) resultDataJson.get("m_isSucess");
            if(resultIsSuccess){
                return AjaxResult.success("调用U9C修改料品信息接口成功:" +  itemInfo.getLotCode());
            }else{
                throw new Exception(StringUtils.format("调用U9C修改料品信息接口失败:" +  resultDataJson.get("m_errorMsg")));
            }
        }else{
            throw new Exception(StringUtils.format("调用U9C修改料品信息接口失败:" + resultJson.get("ResMsg")));
        }
    }

    public AjaxResult insertLotCode(ItemLotCodeInfo itemLotCodeInfo) throws Exception {
        String lotEnableTime = DateUtils.parseDateToStr("YYYY-MM-dd",DateUtils.getNowDate()); //生效日期哦 当前日期
        String disabledTime = DateUtils.parseDateToStr("YYYY-MM-dd",DateUtils.addDays(DateUtils.getNowDate(),1000000)); //失效日期
        JSONObject descFlexFieldJson = new JSONObject();
        switch (itemLotCodeInfo.getPreLevel()){
            case "A":
                descFlexFieldJson.put("PubDescSeg13",1);
                break;
            case "B":
                descFlexFieldJson.put("PubDescSeg13",2);
                break;
            case "C":
                descFlexFieldJson.put("PubDescSeg13",3);
                break;
            case "D":
                descFlexFieldJson.put("PubDescSeg13",4);
                break;
            default:
                descFlexFieldJson.put("PubDescSeg13",2);
                break;
        }
        JSONObject lotCodeJson = new JSONObject();
        lotCodeJson.put("LotCode",itemLotCodeInfo.getLotCode());
        lotCodeJson.put("ItemCode",itemLotCodeInfo.getItemCode());
        lotCodeJson.put("AvailableDate",1000000);
        lotCodeJson.put("LotEnableTime",lotEnableTime);
        lotCodeJson.put("DisabledTime",disabledTime);
        lotCodeJson.put("DescFlexField",descFlexFieldJson);
        lotCodeJson.put("OrgCode","001");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(lotCodeJson);

        String param = jsonArray.toJSONString();
        JSONObject resultJson = u9CUtil.postU9CApi(param,"LotMaster/Create","创建批号主档");
        boolean resultSuccess = (Boolean) resultJson.get("Success");
        if(resultSuccess){
            JSONArray dataArr = (JSONArray) resultJson.get("Data");
            JSONObject resultDataJson = dataArr.getJSONObject(0);
            boolean resultIsSuccess = (Boolean) resultDataJson.get("m_isSucess");
            if(resultIsSuccess){
                return AjaxResult.success("调用U9C批号主档新增接口成功:" +  itemLotCodeInfo.getLotCode());
            }else{
                throw new Exception(StringUtils.format("调用U9C接口批号主档新增接口失败:" +  resultDataJson.get("m_errorMsg")));
            }
        }else{
            throw new Exception(StringUtils.format("调用U9C接口批号主档新增接口失败:" + resultJson.get("ResMsg")));
        }
    }
    public AjaxResult deleteLotCode(ItemLotCodeInfo itemLotCodeInfo) throws Exception {
        JSONObject lotCodeJson = new JSONObject();
        lotCodeJson.put("LotCode",itemLotCodeInfo.getLotCode());
        lotCodeJson.put("LotID",itemLotCodeInfo.getLotId());
        lotCodeJson.put("OrgID","1002301060110009");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(lotCodeJson);

        String param = jsonArray.toJSONString();
        JSONObject resultJson = u9CUtil.postU9CApi(param,"LotMaster/Delete","删除批号主档");
        boolean resultSuccess = (Boolean) resultJson.get("Success");
        if(resultSuccess){
            JSONArray dataArr = (JSONArray) resultJson.get("Data");
            JSONObject resultDataJson = dataArr.getJSONObject(0);
            boolean resultIsSuccess = (Boolean) resultDataJson.get("m_isSucess");
            if(resultIsSuccess){
                return AjaxResult.success("调用U9C批号主档删除接口成功:" +  itemLotCodeInfo.getLotCode());
            }else{
                throw new Exception(StringUtils.format("调用U9C接口批号主档删除接口失败:" +  resultDataJson.get("m_errorMsg")));
            }
        }else{
            throw new Exception(StringUtils.format("调用U9C接口批号主档删除接口失败:" + resultJson.get("ResMsg")));
        }
    }
}
