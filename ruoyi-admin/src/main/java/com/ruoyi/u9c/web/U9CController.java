package com.ruoyi.u9c.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.domain.ArriveQty;
import com.ruoyi.report.domain.selfTest.PriorityQuestion;
import com.ruoyi.report.service.SelfTestService;
import com.ruoyi.service.BPMService;
import com.ruoyi.service.U9CService;
import com.ruoyi.u9c.domain.InvTrans;
import com.ruoyi.u9c.service.InvTransBpmServive;
import com.ruoyi.u9c.service.InvTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
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
    @GetMapping("/createPurchaseOrder/{docNo}")
    @ResponseBody
    public JSONObject createPurchaseOrder(@PathVariable("docNo")String docNo)
    {
        List<String> list = Arrays.asList(docNo.split("-"));
        bpmService.getPOLine(list);
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
}
