package com.ruoyi.report.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.report.domain.*;
import com.ruoyi.report.service.InventoryService;
import com.ruoyi.report.service.ZhiTongRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/report/inventory")
public class InventoryController extends BaseController {

    @Autowired
    private InventoryService inventoryService;
    private String prefix = "report/inventory";
    @GetMapping("/getInventoryTurnover")
    public String getProductPlan()
    {
        return prefix + "/inventory";
    }
    @GetMapping("/getInventoryTurnoverData")
    @ResponseBody
    public JSONObject getInventoryTurnoverData(String monthStr, String agent, ModelMap mmap)
    {
        InventoryTurnoverData inventoryTurnoverData = new InventoryTurnoverData();
        InventoryOfMonth inventoryOfMonth = new InventoryOfMonth(); //
        int monthInventory = 0;
        int currYearShipping = 0;
        float inventoryTurnoverNum = 0.0f;
        String date = DateUtils.dateTime();
        String years = date.substring(0,4);
        monthStr = years + monthStr;
        inventoryTurnoverData.setAgent(agent);
        inventoryTurnoverData.setMonth(monthStr);
        inventoryTurnoverData = inventoryService.getInventoryTurnoverData(inventoryTurnoverData);
        if(inventoryTurnoverData != null){
            int index = inventoryTurnoverData.getCurrYearShipping().indexOf(".");
            currYearShipping = Integer.parseInt(inventoryTurnoverData.getCurrYearShipping().substring(0,index)); //发货量
            monthInventory = inventoryTurnoverData.getMonthInventory() == null ? 0 : Integer.parseInt(inventoryTurnoverData.getMonthInventory()); //前几个月的库存之和
            int month = Integer.parseInt(monthStr);
            inventoryTurnoverNum = monthInventory == 0 ? 0 : currYearShipping/(monthInventory/(month - 1));
            mmap.put("currentInventoryNum", inventoryTurnoverData.getCurrentInventoryNum());
            mmap.put("inventoryTurnoverNum", inventoryTurnoverNum);
        }else{
            mmap.put("currentInventoryNum", "0");
            mmap.put("inventoryTurnoverNum", "0.00%");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }
    @GetMapping("/getInventoryStatusList/{month}/{agent}")
    public String getInventoryStatusList(@PathVariable("month") String month,@PathVariable("agent") String agent, ModelMap mmap)
    {
        mmap.put("month",month);
        mmap.put("agentName",agent);
        return prefix + "/inventoryStatus";
    }
    @PostMapping("/list/{month}/{agent}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("month") String month,@PathVariable("agent") String agent)
    {
        //startPage();
        if("0".equals(agent)){
            agent = "";
        }
        InventoryStatus inventoryStatus = new InventoryStatus();
        inventoryStatus.setAgent(agent);
        String date = DateUtils.dateTime();
        String years = date.substring(0,4);
        month = years + month;
        inventoryStatus.setMonth(month);
        List<InventoryStatus> list = inventoryService.getInventoryStatusList(inventoryStatus);
        return getDataTable(list);
    }
    @GetMapping("/getInventoryOfMonth")
    @ResponseBody
    public JSONObject getInventoryOfMonth(String monthStr, String agent, ModelMap mmap)
    {
        InventoryOfMonth inventoryOfMonth = new InventoryOfMonth();
        InventoryOfMonth inventoryResult = new InventoryOfMonth();
        String paramFirst = String.valueOf(Integer.parseInt(monthStr) - 3);
        String paramSecond = String.valueOf(Integer.parseInt(monthStr) - 2);
        String paramThird = String.valueOf(Integer.parseInt(monthStr) - 1);
        String paramFour = "";
        String paramFive = "";
        String paramSix = "";
        String date = DateUtils.dateTime();
        int years = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(monthStr);
        List<String> monthList = new ArrayList<>();
        if(month == 1){
            years = years - 1;
            paramFirst = "" + years + "08";
            paramSecond = "" + years + "09";
            paramThird = "" + years + "10";
            paramFour = "" + years + "11";
            paramFive = "" + years + "12";
            years = years + 1;
            paramSix = "" + years + "01";

        }
        if(month == 2){
            years = years - 1;
            paramFirst = "" + years + "09";
            paramSecond = "" + years + "10";
            paramThird = "" + years + "11";
            paramFour = "" + years + "12";
            years = years + 1;
            paramFive = "" + years + "01";
            paramSix = "" + years + "02";
        }
        if(month == 3){
            years = years - 1;
            paramFirst = "" + years + "10";
            paramSecond = "" + years + "11";
            paramThird = "" + years + "12";
            years = years + 1;
            paramFour = "" + years + "01";
            paramFive = "" + years + "02";
            paramSix = "" + years + "03";
        }
        if(month == 4){
            years = years - 1;
            paramFirst = "" + years + "11";
            paramSecond = "" + years + "12";
            years = years + 1;
            paramThird = "" + years + "01";
            paramFour = "" + years + "02";
            paramFive = "" + years + "03";
            paramSix = "" + years + "04";
        }
        if(month == 5){
            years = years - 1;
            paramFirst = "" + years + "12";
            years = years + 1;
            paramSecond = "" + years + "01";
            paramThird = "" + years + "02";
            paramFour = "" + years + "03";
            paramFive = "" + years + "04";
            paramSix = "" + years + "05";
        }
        if(month >= 6){
            paramFirst = "" + years + String.valueOf(Integer.parseInt(monthStr) - 5);
            paramSecond = "" + years + String.valueOf(Integer.parseInt(monthStr) - 4);
            paramThird = "" + years + String.valueOf(Integer.parseInt(monthStr) - 3);
            paramFour = "" + years + String.valueOf(Integer.parseInt(monthStr) - 2);
            paramFive = "" + years + String.valueOf(Integer.parseInt(monthStr) - 1);
            paramSix = "" + years + monthStr;
        }
        monthList.add(paramFirst);
        monthList.add(paramSecond);
        monthList.add(paramThird);
        monthList.add(paramFour);
        monthList.add(paramFive);
        monthList.add(paramSix);
        List<InventoryOfMonth> list = new ArrayList<>();
        inventoryOfMonth.setAgent(agent);
        for(int i=0; i<monthList.size(); i++){
            inventoryOfMonth.setMonth(monthList.get(i));
            inventoryResult = inventoryService.getInventoryOfMonth(inventoryOfMonth);
            list.add(inventoryResult);
        }
        mmap.put("monthList",monthList);
        mmap.put("list",list);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }
    @GetMapping("/getInventoryOfCurrent")
    @ResponseBody
    public JSONObject getInventoryOfCurrent(String monthStr, String agent, ModelMap mmap)
    {
        InventoryOfCurrent inventoryOfCurrent = new InventoryOfCurrent();
        inventoryOfCurrent.setAgent(agent);
        inventoryOfCurrent.setMonth(monthStr);
        List<InventoryOfCurrent> list  = inventoryService.getInventoryOfCurrent(inventoryOfCurrent);
        List<String> productList = list.stream().map(InventoryOfCurrent :: getProductName).collect(Collectors.toList());
        List<String> safeStockList = list.stream().map(InventoryOfCurrent :: getSafeInventory).collect(Collectors.toList());
        List<String> actStockList = list.stream().map(InventoryOfCurrent :: getActInventory).collect(Collectors.toList());
        mmap.put("productList",productList);
        mmap.put("safeStockList",safeStockList);
        mmap.put("actStockList",actStockList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }
}
