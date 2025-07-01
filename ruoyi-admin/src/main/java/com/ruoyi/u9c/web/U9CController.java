package com.ruoyi.u9c.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.domain.ArriveQty;
import com.ruoyi.domain.Customer;
import com.ruoyi.domain.FixedFiled;
import com.ruoyi.domain.Supplier;
import com.ruoyi.report.domain.selfTest.PriorityQuestion;
import com.ruoyi.report.service.SelfTestService;
import com.ruoyi.service.BPMService;
import com.ruoyi.service.U9CService;
import com.ruoyi.u9c.domain.InvTrans;
import com.ruoyi.u9c.domain.ItemInfo;
import com.ruoyi.u9c.domain.ItemLotCodeInfo;
import com.ruoyi.u9c.domain.SaleContract;
import com.ruoyi.u9c.service.InvTransBpmServive;
import com.ruoyi.u9c.service.InvTransService;
import com.ruoyi.u9c.service.SaleContractBPMService;
import com.ruoyi.u9c.service.SaleContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/interface/u9c")
public class U9CController extends BaseController {
    @Autowired
    private U9CService u9CService;
    @Autowired
    InvTransService invTransService;
    @Autowired
    InvTransBpmServive invTransBpmServive;
    @Autowired
    BPMService bpmService;
    @Autowired
    SaleContractBPMService saleContractBPMService;
    @Autowired
    SaleContractService saleContractService;
    @GetMapping("/getAssetCode/{assetCard}")
    @ResponseBody
    public JSONObject getAssetCode(@PathVariable("assetCard")String assetCard)
    {
        String assCode = u9CService.getAssetCode(assetCard);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("assCode",assCode);
        return jsonObject;
    }
    @GetMapping("/getItemInfoList")
    @ResponseBody
    public JSONObject getItemInfoList()
    {
        List<InvTrans> list = invTransService.getInvTransList();
        if(list.size() > 0){
            //删除料品库存历史信息
            invTransBpmServive.deleteInvTransHis();
            //插入历史信息表
            invTransBpmServive.insertInvTransHis(list);
            //删除料品库存
            invTransBpmServive.deleteInvTrans();
            //插入料品库存表
            invTransBpmServive.insertInvTrans(list);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","0");
        jsonObject.put("message","调用接口成功！");
        return jsonObject;
    }
    @GetMapping("/createPurchaseOrder/{docNo}/{ids}/{PurDeptCode}/{PurOperCode}")
    @ResponseBody
    public JSONObject createPurchaseOrder(@PathVariable("docNo")String docNo,@PathVariable("ids")String ids,@PathVariable("PurDeptCode")String PurDeptCode,@PathVariable("PurOperCode")String PurOperCode)
    {
        List<String> list = Arrays.asList(docNo.split("-"));
        List<String> idList = Arrays.asList(ids.split("~"));
        bpmService.getPOLine(list,idList,PurDeptCode,PurOperCode);
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }
    @GetMapping("/createPurchaseOrder/{docNo}/{PurDeptCode}/{PurOperCode}")
    @ResponseBody
    public JSONObject createPurchaseOrder(@PathVariable("docNo")String docNo,@PathVariable("PurDeptCode")String PurDeptCode,@PathVariable("PurOperCode")String PurOperCode)
    {
        List<String> list = Arrays.asList(docNo.split("-"));
        List<String> idList = new ArrayList<>();
        bpmService.getPOLine(list,idList,PurDeptCode,PurOperCode);
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }
    /*
    采购申请同步到货数量
     */
    @GetMapping("/synArriveQty")
    @ResponseBody
    public JSONObject synArriveQty(){
        JSONObject result = new JSONObject();
        try{
            List<ArriveQty> list = bpmService.getCaiGouDetail();
            for(ArriveQty qty : list){
                ArriveQty arriveQty = u9CService.selectArriveQty(qty);
                if(arriveQty != null){
                    bpmService.updateArriveQty(arriveQty);
                }
            }
            result.put("code","200");
            result.put("MSG","同步成功！");
        } catch (Exception e) {
            result.put("code","500");
            result.put("MSG",e.toString());
        }
        return result;
    }
    /*
    U9C供应商信息同步到BPM
     */
    @GetMapping("/synSuplier")
    @ResponseBody
    public void synSuplier() throws Exception {
        List<Supplier> list = u9CService.getU9CSupplier();
        bpmService.insertSupplier(list);
    }
    /*
    U9C的资产存放位置信息同步到BPM
     */
    @GetMapping("/synFixedField")
    @ResponseBody
    public void synFixedField() throws Exception {
        List<FixedFiled> list = u9CService.getU9CFixedFiled();
        bpmService.insertFixedFiled(list);
    }
    /*
    U9C的料品单价信息同步到BPM
     */
    @GetMapping("/synItemOfPrice")
    @ResponseBody
    public void synItemOfPrice() throws Exception {
        List<FixedFiled> list = u9CService.getU9CFixedFiled();
        bpmService.insertFixedFiled(list);
    }
    /*
    BPM料品信息同步到U9C
     */
    @GetMapping("/synItemOf/{itemCode}")
    @ResponseBody
    public AjaxResult synItemOf(@PathVariable("itemCode")String itemCode) throws Exception {
        try{
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.setCode(itemCode);
            return u9CService.synItemOf(itemInfo);
        }catch (Exception e){
            return AjaxResult.error(StringUtils.format("调用U9C接口新增料品信息失败: " +  e.toString()));
        }
    }
    /*
    BPM批号主档信息同步到U9C
     */
    @GetMapping("/synItemOfLotCode/{itemCode}/{lotCode}/{preLevel}")
    @ResponseBody
    public void synItemOfLotCode(String itemCode,String lotCode,String preLevel) throws Exception {
        ItemLotCodeInfo itemLotCodeInfo = new ItemLotCodeInfo();
        itemLotCodeInfo.setItemCode(itemCode);
        itemLotCodeInfo.setLotCode(lotCode);
        itemLotCodeInfo.setPreLevel(preLevel);
        u9CService.synItemOfLotCode(itemLotCodeInfo);
    }
    /*
    BPM料品更新信息同步到U9C
     */
    @GetMapping("/updateItemOf/{itemCode}")
    @ResponseBody
    public AjaxResult updateItemOf(@PathVariable("itemCode")String itemCode) throws Exception {
        try{
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.setCode(itemCode);
            return u9CService.updateItemOf(itemInfo);
        }catch (Exception e){
            return AjaxResult.error(StringUtils.format("调用U9C接口修改料品信息失败: " +  e.toString()));
        }
    }
    /*
    BPM批号主档信息同步到U9C
     */
    @GetMapping("/updateItemOfLotCode/{itemCode}")
    @ResponseBody
    public void updateItemOfLotCode(String itemCode) throws Exception {
        ItemLotCodeInfo itemLotCodeInfo = new ItemLotCodeInfo();
        itemLotCodeInfo.setItemCode(itemCode);
        u9CService.synItemOfLotCode(itemLotCodeInfo);
    }
    @GetMapping("/getPrice")
    @ResponseBody
    public String getPrice(@PathParam("itemCode") String itemCode, @PathParam("fact")String fact) throws Exception {
        return bpmService.getPriceByItemCode(itemCode,fact);
    }
    @GetMapping("/getProxyPrice")
    @ResponseBody
    public String getProxyPrice(@PathParam("product") String product, @PathParam("fact")String fact) throws Exception {
        return bpmService.getProxyPrice(product,fact);
    }
    @GetMapping("/synCustomer")
    @ResponseBody
    public void synCustomer() throws Exception {
        List<Customer> list = u9CService.getU9CCustomerInfo();
        bpmService.insertCustomer(list);
    }
    @GetMapping("/updateTotalMnyTC")
    @ResponseBody
    public void updateTotalMnyTC(@PathParam("docId") String docId) throws Exception {
        List<SaleContract> list = saleContractBPMService.getSCList(docId);
        saleContractService.updateTotalMnyTC(list);
    }
}
