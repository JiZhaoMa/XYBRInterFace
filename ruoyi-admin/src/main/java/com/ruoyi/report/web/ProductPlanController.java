package com.ruoyi.report.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.json.JSON;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.report.domain.*;
import com.ruoyi.report.service.ProductPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/report/plan")
public class ProductPlanController extends BaseController {

    @Autowired
    private ProductPlanService productPlanService;
    private String prefix = "report/product";
    @GetMapping("/getProductPlan")
    public String getProductPlan()
    {
        return prefix + "/productPlan";
    }
    @GetMapping("/getProductPlanData")
    @ResponseBody
    public JSONObject getProductPlanData(String monthStr,String agent, ModelMap mmap)
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
            paramFirst = "" + years + "0" + String.valueOf(Integer.parseInt(monthStr) - 5);
            paramSecond = "" + years + "0" + String.valueOf(Integer.parseInt(monthStr) - 4);
            paramThird = "" + years + "0" + String.valueOf(Integer.parseInt(monthStr) - 3);
            if(Integer.parseInt(monthStr) - 2 > 9){
                paramFour = "" + years + String.valueOf(Integer.parseInt(monthStr) - 2 );
            }else{
                paramFour = "" + years + "0" + String.valueOf(Integer.parseInt(monthStr) - 2 );
            }
            if(Integer.parseInt(monthStr) - 1 > 9){
                paramFive = "" + years + String.valueOf(Integer.parseInt(monthStr) - 1);
            }else{
                paramFive = "" + years + "0" + String.valueOf(Integer.parseInt(monthStr) - 1);
            }
            paramSix = "" + years + monthStr;
        }
        monthList.add(paramFirst);
        monthList.add(paramSecond);
        monthList.add(paramThird);
        monthList.add(paramFour);
        monthList.add(paramFive);
        monthList.add(paramSix);
        ShippingNumOfMonth shippingNumOfMonth = new ShippingNumOfMonth();
        shippingNumOfMonth.setMonthList(monthList);
        shippingNumOfMonth.setAgent(agent);
        List<ShippingNumOfMonth> shippingNumOfMonthList = productPlanService.getShippingNumOfMonth(shippingNumOfMonth);
        String finalParamFirst = paramFirst;
        List<ShippingNumOfMonth> FirstMonthList = shippingNumOfMonthList.stream().filter(item -> item.getMonth().equals(finalParamFirst)).collect(Collectors.toList());
        String finalParamSecond = paramSecond;
        List<ShippingNumOfMonth> SecondMonthList = shippingNumOfMonthList.stream().filter(item -> item.getMonth().equals(finalParamSecond)).collect(Collectors.toList());
        String finalParamThird = paramThird;
        List<ShippingNumOfMonth> ThirdMonthList = shippingNumOfMonthList.stream().filter(item -> item.getMonth().equals(finalParamThird)).collect(Collectors.toList());
        String finalParamFour = paramFour;
        List<ShippingNumOfMonth> FourMonthList = shippingNumOfMonthList.stream().filter(item -> item.getMonth().equals(finalParamFour)).collect(Collectors.toList());
        String finalParamFive = paramFive;
        List<ShippingNumOfMonth> FiveMonthList = shippingNumOfMonthList.stream().filter(item -> item.getMonth().equals(finalParamFive)).collect(Collectors.toList());
        String finalParamSix = paramSix;
        List<ShippingNumOfMonth> SixMonthList = shippingNumOfMonthList.stream().filter(item -> item.getMonth().equals(finalParamSix)).collect(Collectors.toList());

        List<ShippingNumOfMonth> seriseName = productPlanService.getSeriseName(shippingNumOfMonth);
        mmap.put("FirstMonthList", FirstMonthList);
        mmap.put("SecondMonthList", SecondMonthList);
        mmap.put("ThirdMonthList", ThirdMonthList);
        mmap.put("FourMonthList", FourMonthList);
        mmap.put("FiveMonthList", FiveMonthList);
        mmap.put("SixMonthList", SixMonthList);
        mmap.put("monthList", monthList);
        mmap.put("seriseName", seriseName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }

    @GetMapping("/getPlanSumData")
    @ResponseBody
    public JSONObject getPlanSumData(String monthStr, String agent, ModelMap mmap)
    {
        String paramFirst = "";
        String paramSecond = "";
        String paramThird = "";
        String paramFour = "";
        String date = DateUtils.dateTime();
        int years = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(monthStr);

        if(month == 1){
            paramFour = "" + years + "01";
            years = years - 1;
            paramFirst = "" + years + "10";
            paramSecond = "" + years + "11";
            paramThird = "" + years + "12";
        }
        if(month == 2){
            years = years - 1;
            paramFirst = "" + years + "11";
            paramSecond = "" + years + "12";
            years = years + 1;
            paramThird = "" + years + "01";
            paramFour = "" + years + "02";
        }
        if(month == 3){
            years = years - 1;
            paramFirst = "" + years + "12";
            years = years + 1;
            paramSecond = "" + years + "01";
            paramThird = "" + years + "02";
            paramFour = "" + years + "03";
        }
        if(month > 3){
            paramFirst = "" + years + ((Integer.parseInt(monthStr) - 3) > 9 ? (Integer.parseInt(monthStr) - 3) : "0" + String.valueOf(Integer.parseInt(monthStr) - 3));
            paramSecond = "" + years + ((Integer.parseInt(monthStr) - 2) > 9 ? (Integer.parseInt(monthStr) - 2) : "0" + String.valueOf(Integer.parseInt(monthStr) - 2));
            paramThird = "" + years + ((Integer.parseInt(monthStr) - 1) > 9 ? (Integer.parseInt(monthStr) - 1) : "0" + String.valueOf(Integer.parseInt(monthStr) - 1));
            paramFour = "" + years + monthStr;
        }
        MonthPlan monthPlan = new MonthPlan();
        mmap.put("monthOfFirst", paramFirst.substring(4,6)+"月");
        mmap.put("monthOfSecond", paramSecond.substring(4,6)+"月");
        mmap.put("monthOfThird", paramThird.substring(4,6)+"月");
        mmap.put("paramFour", paramFour.substring(4,6)+"月");
        if(agent.equals("0")){
            agent = "";
        }
        monthPlan.setAgent(agent);
        monthPlan.setMonth(paramFirst);
        MonthPlan firstResult = productPlanService.monthOfPlan(monthPlan);
        monthPlan.setMonth(paramSecond);
        MonthPlan secondResult = productPlanService.monthOfPlan(monthPlan);
        monthPlan.setMonth(paramThird);
        MonthPlan thirdResult = productPlanService.monthOfPlan(monthPlan);
        monthPlan.setMonth(paramFour);
        MonthPlan fourResult = productPlanService.monthOfPlan(monthPlan);
        if(firstResult == null){
            mmap.put("monthOfFirstPlan", "0");
            mmap.put("monthOfFirstFinsh", "0");
        }else{
            mmap.put("monthOfFirstPlan", firstResult.getPlan());
            mmap.put("monthOfFirstFinsh", firstResult.getFinshRate());
        }
        if(secondResult == null){
            mmap.put("monthOfSecondPlan", "0");
            mmap.put("monthOfSecondFinsh", "0");
        }else{
            mmap.put("monthOfSecondPlan", secondResult.getPlan());
            mmap.put("monthOfSecondFinsh", secondResult.getFinshRate());
        }
        if(thirdResult == null){
            mmap.put("monthOfThirdPlan", "0");
            mmap.put("monthOfThirdFinsh", "0");
        }else{
            mmap.put("monthOfThirdPlan", thirdResult.getPlan());
            mmap.put("monthOfThirdFinsh", thirdResult.getFinshRate());
        }
        if(fourResult == null){
            mmap.put("monthOfFourPlan", "0");
            mmap.put("monthOfFourFinsh", "0");
        }else{
            mmap.put("monthOfFourPlan", fourResult.getPlan());
            mmap.put("monthOfFourFinsh", fourResult.getFinish());
        }
        /*mmap.put("monthOfFirstPlan", "9000");
        mmap.put("monthOfSecondPlan", "10000");
        mmap.put("monthOfThirdPlan", "8000");
        mmap.put("monthOfFirstFinsh", "100%");
        mmap.put("monthOfSecondFinsh", "99%");
        mmap.put("monthOfThirdFinsh", "99.99%");*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }
    @GetMapping("/getShippingData")
    @ResponseBody
    public JSONObject getShippingData(String agent, ModelMap mmap)
    {
        ShippingDataRate shippingDataRate = new ShippingDataRate();
        shippingDataRate.setAgent(agent);
        List<ShippingDataRate> shippingList = productPlanService.shippingDataRate(shippingDataRate);
        mmap.put("shippingFirstSerise", shippingList.get(0).getSERISE());
        mmap.put("shippingSecondSerise", shippingList.get(1).getSERISE());
        mmap.put("shippingThirdSerise", shippingList.get(2).getSERISE());
        mmap.put("shippingDataNumFirst", shippingList.get(0).getNum());
        mmap.put("shippingDataNumSecond", shippingList.get(1).getNum());
        mmap.put("shippingDataNumThird", shippingList.get(2).getNum());
       /* mmap.put("shippingFirstSerise", "20kW");
        mmap.put("shippingSecondSerise", "30kW");
        mmap.put("shippingThirdSerise", "40kW");
        mmap.put("shippingDataNumFirst", "10000");
        mmap.put("shippingDataNumSecond", "58945");
        mmap.put("shippingDataNumThird", "9587");*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mmap",mmap);
        return jsonObject;
    }

    @GetMapping("/getProductPlanOfMonth/{month}/{agent}")
    public String getProductPlanOfMonth(@PathVariable("month") String month,@PathVariable("agent") String agent, ModelMap mmap)
    {
        mmap.put("month",month);
        mmap.put("agentName",agent);
        return prefix + "/planMonthList";
    }
    @PostMapping("/list/{month}/{agent}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("month") String month,@PathVariable("agent") String agent)
    {
        ProductPlanOfMonth productPlanOfMonth = new ProductPlanOfMonth();
        if("0".equals(agent)){
            agent = "";
        }
        String date = DateUtils.dateTime();
        int years = Integer.parseInt(date.substring(0,4));
        month = years + month;
        productPlanOfMonth.setMonth(month);
        productPlanOfMonth.setAgent(agent);
        List<ProductPlanOfMonth> list = productPlanService.selectproductPlanOfMonthList(productPlanOfMonth);
        return getDataTable(list);
    }
}
