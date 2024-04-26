package com.ruoyi.report.domain;

import java.text.DecimalFormat;
import java.util.List;

public class MonthOfZhiTongRate {
    private String month;
    private List<String> monthList;
    private String agent;
    private String seriesName;
    private String productSum;
    private String zhiTongRate;

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getProductSum() {
        if(productSum == null){
            return productSum;
        }else{
            double number = Double.parseDouble(productSum);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setProductSum(String productSum) {
        this.productSum = productSum;
    }

    public String getZhiTongRate() {
        return zhiTongRate;
    }

    public void setZhiTongRate(String zhiTongRate) {
        this.zhiTongRate = zhiTongRate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }
}
