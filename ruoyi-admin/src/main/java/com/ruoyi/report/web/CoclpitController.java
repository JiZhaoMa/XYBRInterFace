package com.ruoyi.report.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.report.domain.MonthOfZhiTongRate;
import com.ruoyi.report.domain.cockpit.*;
import com.ruoyi.report.service.CockpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * XybrOrderController
 * @author ruoyi
 * @date 2024-03-19
 */
@Controller
@RequestMapping("/system/cockpit")
public class CoclpitController extends BaseController
{
    private String prefix = "report/businessManagementCockpit";

    @Autowired
    private CockpitService cockpitService;
    @GetMapping("/getView")
    public String getCockpit()
    {
        return prefix + "/cockpit";
    }
    @GetMapping("/getXuanZhuanMuMa")
    public String getXuanZhuanMuMa()
    {
        return prefix + "/xuanZhuanMuMa";
    }
    @GetMapping("/getViewData")
    @ResponseBody
    public JSONObject getCockpitData(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        CockpitData cockpitData = cockpitService.getCockpitData(monthStr);
        List<TenClient> tenClientList = cockpitService.getTenClient(monthStr);
        List<Performance> performaneList = cockpitService.getPerformance(monthStr);
        List<ProjectInfo> projectInfoList = cockpitService.getProjectInfo(monthStr);
        List<ZhuanLi> zhuanLiList = cockpitService.getZhuanLiList(monthStr);
        jsonObject.put("zhuanLiList",zhuanLiList);
        jsonObject.put("cockpitData",cockpitData);
        jsonObject.put("monthList",cockpitData.getMonthList());
        jsonObject.put("tenClientList",tenClientList);
        jsonObject.put("performaneList",performaneList);
        jsonObject.put("projectInfoList",projectInfoList);
        return jsonObject;
    }
    @GetMapping("/getYuQiData")
    @ResponseBody
    public JSONObject getYuQiData(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<YuQiClientData> yuQiClientDataList = cockpitService.getYuQiClientData(monthStr);
        List<String> nameList = new ArrayList<>();
        List<String> yuQiList01 = new ArrayList<>();
        List<String> yuQiList02 = new ArrayList<>();
        List<String> yuQiList03 = new ArrayList<>();
        for(YuQiClientData data : yuQiClientDataList){
            nameList.add(data.getName());
            yuQiList01.add(data.getYuQi001());
            yuQiList02.add(data.getYuQi002());
            yuQiList03.add(data.getYuQi003());
        }
        jsonObject.put("nameList",nameList);
        jsonObject.put("yuQiList01",yuQiList01);
        jsonObject.put("yuQiList02",yuQiList02);
        jsonObject.put("yuQiList03",yuQiList03);
        return jsonObject;
    }
    @GetMapping("/getStockData")
    @ResponseBody
    public JSONObject getStockData(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        StockData stockData = cockpitService.getStockData(monthStr);
        jsonObject.put("stockData",stockData);
        return jsonObject;
    }

    @GetMapping("/getJiangBneMuBiao")
    @ResponseBody
    public JSONObject getJiangBneMuBiao(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<JiangBneMuBiao> jiangBneMuBiaoData = cockpitService.getJiangBneMuBiao(monthStr);
        List<String> monthLists = jiangBneMuBiaoData.stream().map(JiangBneMuBiao::getMonth).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<JiangBneMuBiao> valueList20kW = jiangBneMuBiaoData.stream().filter(item -> "20kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list20kW = valueList20kW.stream().map(JiangBneMuBiao::getValue).collect(Collectors.toList());
        List<JiangBneMuBiao> valueList30kW = jiangBneMuBiaoData.stream().filter(item -> "30kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list30kW = valueList30kW.stream().map(JiangBneMuBiao::getValue).collect(Collectors.toList());
        List<JiangBneMuBiao> valueList40kW = jiangBneMuBiaoData.stream().filter(item -> "40kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list40kW = valueList40kW.stream().map(JiangBneMuBiao::getValue).collect(Collectors.toList());
        jsonObject.put("monthLists",monthLists);
        jsonObject.put("list20kW",list20kW);
        jsonObject.put("list30kW",list30kW);
        jsonObject.put("list40kW",list40kW);
        return jsonObject;
    }
    @GetMapping("/getAnShiJiaoFu")
    @ResponseBody
    public JSONObject getAnShiJiaoFu(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<AnShiJiaoFu> anShiJiaoFuData = cockpitService.getAnShiJiaoFu(monthStr);
        List<String> monthLists = anShiJiaoFuData.stream().map(AnShiJiaoFu::getMonth).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<AnShiJiaoFu> valueList20kW = anShiJiaoFuData.stream().filter(item -> "20kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list20kW = valueList20kW.stream().map(AnShiJiaoFu::getValue).collect(Collectors.toList());
        List<AnShiJiaoFu> valueList30kW = anShiJiaoFuData.stream().filter(item -> "30kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list30kW = valueList30kW.stream().map(AnShiJiaoFu::getValue).collect(Collectors.toList());
        List<AnShiJiaoFu> valueList40kW = anShiJiaoFuData.stream().filter(item -> "40kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list40kW = valueList40kW.stream().map(AnShiJiaoFu::getValue).collect(Collectors.toList());
        jsonObject.put("monthLists",monthLists);
        jsonObject.put("list20kW",list20kW);
        jsonObject.put("list30kW",list30kW);
        jsonObject.put("list40kW",list40kW);
        return jsonObject;
    }
    @GetMapping("/getMaoLi")
    @ResponseBody
    public JSONObject getMaoLi(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<MaoLi> maoLiData = cockpitService.getMaoLi(monthStr);
        List<String> monthLists = maoLiData.stream().map(MaoLi::getMonth).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<MaoLi> valueList20kW = maoLiData.stream().filter(item -> "20kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list20kW = valueList20kW.stream().map(MaoLi::getValue).collect(Collectors.toList());
        List<MaoLi> valueList30kW = maoLiData.stream().filter(item -> "30kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list30kW = valueList30kW.stream().map(MaoLi::getValue).collect(Collectors.toList());
        List<MaoLi> valueList40kW = maoLiData.stream().filter(item -> "40kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list40kW = valueList40kW.stream().map(MaoLi::getValue).collect(Collectors.toList());
        jsonObject.put("monthLists",monthLists);
        jsonObject.put("list20kW",list20kW);
        jsonObject.put("list30kW",list30kW);
        jsonObject.put("list40kW",list40kW);
        return jsonObject;
    }
    @GetMapping("/getQIJianFeiYongRate")
    @ResponseBody
    public JSONObject getQIJianFeiYongRate(String currentMonth,String yearsAgoMonth,String agoMonth)
    {
        JSONObject jsonObject = new JSONObject();
        CockpitData cockpitData = new CockpitData();
        cockpitData.setCurrentMonth(currentMonth);
        cockpitData.setYearsAgoMonth(yearsAgoMonth);
        cockpitData.setAgoMonth(agoMonth);
        List<QIJianFeiYongRate> qIJianFeiYongRateData = cockpitService.getQIJianFeiYongRate(cockpitData);
        List<QIJianFeiYongRate> yearsAgoList = qIJianFeiYongRateData.stream().filter(item -> yearsAgoMonth.equals(item.getMonth())).collect(Collectors.toList());
        List<QIJianFeiYongRate> monthAgoList = qIJianFeiYongRateData.stream().filter(item -> agoMonth.equals(item.getMonth())).collect(Collectors.toList());
        List<QIJianFeiYongRate> monthCurrList = qIJianFeiYongRateData.stream().filter(item -> currentMonth.equals(item.getMonth())).collect(Collectors.toList());
        List<String> ratelist = monthCurrList.stream().map(QIJianFeiYongRate::getRate).collect(Collectors.toList());
        List<String> typelist = monthCurrList.stream().map(QIJianFeiYongRate::getType).collect(Collectors.toList());
        jsonObject.put("yearsAgoList",yearsAgoList);
        jsonObject.put("monthAgoList",monthAgoList);
        jsonObject.put("monthCurrList",monthCurrList);
        jsonObject.put("ratelist",ratelist);
        jsonObject.put("typelist",typelist);
        return jsonObject;
    }
    @GetMapping("/getChanPinZhiTongRate")
    @ResponseBody
    public JSONObject getChanPinZhiTongRate(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<ChanPinZhiTongRate> chanPinZhiTongRateData = cockpitService.getChanPinZhiTongRate(monthStr);
        List<String> monthLists = chanPinZhiTongRateData.stream().map(ChanPinZhiTongRate::getMonth).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<ChanPinZhiTongRate> valueList20kW = chanPinZhiTongRateData.stream().filter(item -> "20kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list20kW = valueList20kW.stream().map(ChanPinZhiTongRate::getValue).collect(Collectors.toList());
        List<ChanPinZhiTongRate> valueList30kW = chanPinZhiTongRateData.stream().filter(item -> "30kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list30kW = valueList30kW.stream().map(ChanPinZhiTongRate::getValue).collect(Collectors.toList());
        List<ChanPinZhiTongRate> valueList40kW = chanPinZhiTongRateData.stream().filter(item -> "40kW".equals(item.getProduct())).collect(Collectors.toList());
        List<String> list40kW = valueList40kW.stream().map(ChanPinZhiTongRate::getValue).collect(Collectors.toList());
        jsonObject.put("monthLists",monthLists);
        jsonObject.put("list20kW",list20kW);
        jsonObject.put("list30kW",list30kW);
        jsonObject.put("list40kW",list40kW);
        return jsonObject;
    }
    @GetMapping("/getShiChangGuZhangRate")
    @ResponseBody
    public JSONObject getShiChangGuZhangRate(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<ShiChangGuZhangRate> shiChangGuZhangRateData = cockpitService.getShiChangGuZhangRate(monthStr);
        List<String> monthLists = shiChangGuZhangRateData.stream().map(ShiChangGuZhangRate::getMonth).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<ShiChangGuZhangRate> valueListIn = shiChangGuZhangRateData.stream().filter(item -> "量产一年内".equals(item.getProduct())).collect(Collectors.toList());
        List<String> listIn = valueListIn.stream().map(ShiChangGuZhangRate::getValue).collect(Collectors.toList());
        List<ShiChangGuZhangRate> valueListOut = shiChangGuZhangRateData.stream().filter(item -> "量产一年外".equals(item.getProduct())).collect(Collectors.toList());
        List<String> listOut = valueListOut.stream().map(ShiChangGuZhangRate::getValue).collect(Collectors.toList());
        jsonObject.put("monthLists",monthLists);
        jsonObject.put("listIn",listIn);
        jsonObject.put("listOut",listOut);
        return jsonObject;
    }
    @GetMapping("/getKaiXiangBuLiangRate")
    @ResponseBody
    public JSONObject getKaiXiangBuLiangRate(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<KaiXiangBuLiangRate> kaiXiangBuLiangRateData = cockpitService.getKaiXiangBuLiangRate(monthStr);
        List<String> monthLists = kaiXiangBuLiangRateData.stream().map(KaiXiangBuLiangRate::getMonth).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<KaiXiangBuLiangRate> valueListIn = kaiXiangBuLiangRateData.stream().filter(item -> "量产一年内".equals(item.getProduct())).collect(Collectors.toList());
        List<String> listIn = valueListIn.stream().map(KaiXiangBuLiangRate::getValue).collect(Collectors.toList());
        List<KaiXiangBuLiangRate> valueListOut = kaiXiangBuLiangRateData.stream().filter(item -> "量产一年外".equals(item.getProduct())).collect(Collectors.toList());
        List<String> listOut = valueListOut.stream().map(KaiXiangBuLiangRate::getValue).collect(Collectors.toList());
        jsonObject.put("monthLists",monthLists);
        jsonObject.put("listIn",listIn);
        jsonObject.put("listOut",listOut);
        return jsonObject;
    }
    @GetMapping("/getChanPinQiDongRate")
    @ResponseBody
    public JSONObject getChanPinQiDongRate(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<ChanPinQiDongRate> chanPinQiDongRate = cockpitService.getChanPinQiDongRate(monthStr);
        List<String> departmentList = chanPinQiDongRate.stream().map(ChanPinQiDongRate::getQiDongRateDepartment).collect(Collectors.toList());
        List<String> qiDongList = chanPinQiDongRate.stream().map(ChanPinQiDongRate::getQiDongNum).collect(Collectors.toList());
        List<String> guiHuaList = chanPinQiDongRate.stream().map(ChanPinQiDongRate::getGuiHuaNum).collect(Collectors.toList());
        jsonObject.put("departmentList",departmentList);
        jsonObject.put("qiDongList",qiDongList);
        jsonObject.put("guiHuaList",guiHuaList);
        return jsonObject;
    }
    @GetMapping("/getZhuanLiData")
    @ResponseBody
    public JSONObject getZhuanLiData(String monthStr)
    {
        JSONObject jsonObject = new JSONObject();
        List<ZhuanLi> zhuanLiList = cockpitService.getZhuanLiList(monthStr);
        jsonObject.put("zhuanLiList",zhuanLiList);
        return jsonObject;
    }
}
