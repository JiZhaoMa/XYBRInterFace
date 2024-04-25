package com.ruoyi.report.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.report.domain.*;
import com.ruoyi.report.service.ProductPlanService;
import com.ruoyi.report.service.ZhiTongRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/report/zhiTongRate")
public class ZhiTongRateController extends BaseController {

    @Autowired
    private ZhiTongRateService zhiTongRateService;
    private String prefix = "report/zhiTongRate";
    @GetMapping("/getZhiTongRate")
    public String getProductPlan()
    {
        return prefix + "/zhiTongRate";
    }
    @GetMapping("/getFirstZhiTongRate")
    @ResponseBody
    public JSONObject getFirstZhiTongRate(String monthStr, String agent, ModelMap mmap)
    {
        String date = DateUtils.dateTime();
        int years = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(monthStr);
        if(month > 9){
            monthStr = "" + years + String.valueOf(Integer.parseInt(monthStr));
        }else{
            monthStr = "" + years + "0" + String.valueOf(Integer.parseInt(monthStr));
        }
        CurrentZhiTongRate currentZhiTongRate = new CurrentZhiTongRate();
        currentZhiTongRate.setAgent(agent);
        currentZhiTongRate.setMonth(monthStr);
        List<CurrentZhiTongRate> list = zhiTongRateService.getCurMonZhiTongRate(currentZhiTongRate);
        mmap.put("seriesNameOfFirst", list.size() > 0 ? list.get(0).getSeriesName() : "");
        mmap.put("seriesNameOfSecond", list.size() > 1 ? list.get(1).getSeriesName() : "");
        mmap.put("seriesNameOfThird", list.size() > 2 ? list.get(2).getSeriesName() : "");
        mmap.put("seriesOfFirst", list.size() > 0 && list.get(0).getSeriesNum() != null ? list.get(0).getSeriesNum() : "0");
        mmap.put("seriesOfSecond", list.size() > 1 && list.get(1).getSeriesNum() != null ? list.get(1).getSeriesNum() : "0");
        mmap.put("seriesOfThird", list.size() > 2 && list.get(2).getSeriesNum() != null  ? list.get(2).getSeriesNum() : "0");
        CurrentZhiTongRate zongHeZhiTongRate = zhiTongRateService.getZongHeZhiTongRate(currentZhiTongRate);
        //老化前
        mmap.put("laoHuaqianTestNum",zongHeZhiTongRate != null ? zongHeZhiTongRate.getLaoHuaqianTestNum() : "0");
        mmap.put("laoHuaqianZhiTongNum",zongHeZhiTongRate != null ? zongHeZhiTongRate.getLaoHuaqianZhiTongNum() : "0");
        //老化
        mmap.put("laoHuaTestNum",zongHeZhiTongRate != null ? zongHeZhiTongRate.getLaoHuaTestNum() : "0");
        mmap.put("laoHuaZhiTongNum",zongHeZhiTongRate != null ? zongHeZhiTongRate.getLaoHuaZhiTongNum() : "0");
        //老化后
        mmap.put("laoHuaHouTestNum",zongHeZhiTongRate != null ? zongHeZhiTongRate.getLaoHuaHouTestNum() : "0");
        mmap.put("laoHuaHouZhiTongNum",zongHeZhiTongRate != null ? zongHeZhiTongRate.getLaoHuaHouZhiTongNum() : "0");
        //综合
        mmap.put("naiYaTestNum",zongHeZhiTongRate != null ? zongHeZhiTongRate.getNaiYaTestNum() : "0");
        mmap.put("naiYaZhiTongNum",zongHeZhiTongRate != null ? zongHeZhiTongRate.getNaiYaZhiTongNum() : "0");

        /*mmap.put("zhiTongRateCurrMonth", "0.98");//当月直通率*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }
    @GetMapping("/getSeriesFirstZhiTongRate/{month}/{agent}/{stage}")
    public String getSeriesFirstZhiTongRate(@PathVariable("month") String month,@PathVariable("agent") String agent, @PathVariable("stage") String stage, ModelMap mmap)
    {
        mmap.put("month",month);
        mmap.put("agentName",agent);
        mmap.put("stage",stage);
        return prefix + "/seriseFirstRate";
    }
    @PostMapping("/list/{month}/{agent}/{stage}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("month") String month,@PathVariable("agent") String agent,@PathVariable("stage") String stage)
    {
        startPage();
        if("0".equals(agent)){
            agent = "";
        }
        String date = DateUtils.dateTime();
        month = date.substring(0,4) + month;
        SeriesFirstZhiTongRate seriesFirstZhiTongRate = new SeriesFirstZhiTongRate();
        seriesFirstZhiTongRate.setAgent(agent);
        seriesFirstZhiTongRate.setMonth(month);
        if("老化前".equals(stage) || "老化后".equals(stage)){
            seriesFirstZhiTongRate.setStageTest(stage+"测试数量");
            seriesFirstZhiTongRate.setStageZhiTong(stage+"测试一次直通数量");
        }else if("老化".equals(stage) || "耐压".equals(stage)){
            seriesFirstZhiTongRate.setStageTest(stage+"测试数量");
            seriesFirstZhiTongRate.setStageZhiTong(stage+"直通数量");
        }else{
            seriesFirstZhiTongRate.setStageTest("综合");
            seriesFirstZhiTongRate.setStageZhiTong("综合");
        }


        List<SeriesFirstZhiTongRate> list = new ArrayList<>();
        list = zhiTongRateService.getSeriesFirstZhiTongRate(seriesFirstZhiTongRate);
        return getDataTable(list);
    }
    @GetMapping("/getCurYearSumZhiTongRate")
    @ResponseBody
    public JSONObject getCurYearSumZhiTongRate(String monthStr, String agent, ModelMap mmap)
    {
        CurYearSumZhiTongRate curYearSumZhiTongRate = new CurYearSumZhiTongRate();
        curYearSumZhiTongRate.setAgent(agent);
        String date = DateUtils.dateTime();
        int years = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6));
        curYearSumZhiTongRate.setStartMonth("" + years + "01");
        curYearSumZhiTongRate.setEndMonth("" + years + month);
        List<CurYearSumZhiTongRate> list = zhiTongRateService.getCurYearSumZhiTongRate(curYearSumZhiTongRate);
        mmap.put("seriesNameFirst", list.size() > 0 ? list.get(0).getSeriesName() : "");
        mmap.put("seriesNameSecond", list.size() > 1 ? list.get(1).getSeriesName() : "");
        mmap.put("seriesNameThird", list.size() > 2 ? list.get(2).getSeriesName() : "");
        mmap.put("seriesOfSumFirst", list.size() > 0 ? (list.get(0).getProductSum() == null ? "0" : list.get(0).getProductSum()) : "0");
        mmap.put("seriesOfSumSecond", list.size() > 1 ? (list.get(1).getProductSum() == null ? "0" : list.get(1).getProductSum()) : "0");
        mmap.put("seriesOfSumThird", list.size() > 2 ? (list.get(2).getProductSum() == null ? "0" : list.get(2).getProductSum()) : "0");
        mmap.put("seriesOfRateFirst", list.size() > 0 ? (list.get(0).getZhiTongRate() == null ? "0" : list.get(0).getZhiTongRate()) : "0");
        mmap.put("seriesOfRateSecond", list.size() > 1 ? (list.get(1).getZhiTongRate() == null ? "0" : list.get(1).getZhiTongRate()) : "0");
        mmap.put("seriesOfRateThird", list.size() > 2 ? (list.get(2).getZhiTongRate() == null ? "0" : list.get(2).getZhiTongRate()) : "0");
        /*mmap.put("seriesNameFirst", "20Kw");
        mmap.put("seriesNameSecond", "30Kw");
        mmap.put("seriesNameThird", "40Kw");
        mmap.put("seriesOfSumFirst", "9000");
        mmap.put("seriesOfSumSecond", "8000");
        mmap.put("seriesOfSumThird", "8500");
        mmap.put("seriesOfRateFirst", "95%");
        mmap.put("seriesOfRateSecond", "90%");
        mmap.put("seriesOfRateThird", "99");*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }
    @GetMapping("/getMonthOfZhiTongRate")
    @ResponseBody
    public JSONObject getMonthOfZhiTongRate(String agent, String monthStr, String seriesName, ModelMap mmap)
    {
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
        MonthOfZhiTongRate monthOfZhiTongRate = new MonthOfZhiTongRate();
        monthOfZhiTongRate.setAgent(agent);
        monthOfZhiTongRate.setSeriesName(seriesName);
        monthOfZhiTongRate.setMonthList(monthList);
        monthOfZhiTongRate.setSeriesName(seriesName);
        List<MonthOfZhiTongRate> list = zhiTongRateService.getMonthOfZhiTongRate(monthOfZhiTongRate);
        List<MonthOfZhiTongRate> stockList = zhiTongRateService.getMonthOfStock(monthOfZhiTongRate);
        String finalParamFirst = paramFirst;
        List<MonthOfZhiTongRate> FirstMonthZhiTongRateList = list.stream().filter(item -> finalParamFirst.equals(item.getMonth())).collect(Collectors.toList());
        List<MonthOfZhiTongRate> FirstMonthStockList = stockList.stream().filter(item -> finalParamFirst.equals(item.getMonth())).collect(Collectors.toList());
        String finalParamSecond = paramSecond;
        List<MonthOfZhiTongRate> SecondMonthZhiTongRateList = list.stream().filter(item -> finalParamSecond.equals(item.getMonth())).collect(Collectors.toList());
        List<MonthOfZhiTongRate> SecondMonthStockList = stockList.stream().filter(item -> finalParamSecond.equals(item.getMonth())).collect(Collectors.toList());
        String finalParamThird = paramThird;
        List<MonthOfZhiTongRate> ThirdMonthZhiTongRateList = list.stream().filter(item -> finalParamThird.equals(item.getMonth())).collect(Collectors.toList());
        List<MonthOfZhiTongRate> ThirdMonthStockList = stockList.stream().filter(item -> finalParamThird.equals(item.getMonth())).collect(Collectors.toList());
        String finalParamFour = paramFour;
        List<MonthOfZhiTongRate> FourMonthZhiTongRateList = list.stream().filter(item -> finalParamFour.equals(item.getMonth())).collect(Collectors.toList());
        List<MonthOfZhiTongRate> FourMonthStockList = stockList.stream().filter(item -> finalParamFour.equals(item.getMonth())).collect(Collectors.toList());
        String finalParamFive = paramFive;
        List<MonthOfZhiTongRate> FiveMonthZhiTongRateList = list.stream().filter(item -> finalParamFive.equals(item.getMonth())).collect(Collectors.toList());
        List<MonthOfZhiTongRate> FiveMonthStockList = stockList.stream().filter(item -> finalParamFive.equals(item.getMonth())).collect(Collectors.toList());
        String finalParamSix = paramSix;
        List<MonthOfZhiTongRate> SixMonthZhiTongRateList = list.stream().filter(item -> finalParamSix.equals(item.getMonth())).collect(Collectors.toList());
        List<MonthOfZhiTongRate> SixMonthStockList = stockList.stream().filter(item -> finalParamSix.equals(item.getMonth())).collect(Collectors.toList());

        mmap.put("FirstMonthZhiTongRateList", FirstMonthZhiTongRateList);
        mmap.put("SecondMonthZhiTongRateList", SecondMonthZhiTongRateList);
        mmap.put("ThirdMonthZhiTongRateList", ThirdMonthZhiTongRateList);
        mmap.put("FourMonthZhiTongRateList", FourMonthZhiTongRateList);
        mmap.put("FiveMonthZhiTongRateList", FiveMonthZhiTongRateList);
        mmap.put("SixMonthZhiTongRateList", SixMonthZhiTongRateList);

        mmap.put("FirstMonthStockList", FirstMonthStockList);
        mmap.put("SecondMonthStockList", SecondMonthStockList);
        mmap.put("ThirdMonthStockList", ThirdMonthStockList);
        mmap.put("FourMonthStockList", FourMonthStockList);
        mmap.put("FiveMonthStockList", FiveMonthStockList);
        mmap.put("SixMonthStockList", SixMonthStockList);
        mmap.put("monthList", monthList);
        mmap.put("seriesName", seriesName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }
}
