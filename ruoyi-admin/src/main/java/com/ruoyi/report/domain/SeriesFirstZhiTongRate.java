package com.ruoyi.report.domain;

import java.text.DecimalFormat;

public class SeriesFirstZhiTongRate {
    private String month;
    private String agent;
    private String seriesName;
    private String testNum;
    private String zhiTongNum;
    private String zhiTongRate;
    private String stageTest;
    public String getStageTest() {
        return stageTest;
    }

    public void setStageTest(String stageTest) {
        this.stageTest = stageTest;
    }

    public String getStageZhiTong() {
        return stageZhiTong;
    }

    public void setStageZhiTong(String stageZhiTong) {
        this.stageZhiTong = stageZhiTong;
    }

    private String stageZhiTong;
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

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getTestNum() {
        if(testNum == null){
            return testNum;
        }else{
            double number = Double.parseDouble(testNum);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setTestNum(String testNum) {
        this.testNum = testNum;
    }

    public String getZhiTongNum() {
        if(zhiTongNum == null){
            return zhiTongNum;
        }else{
            double number = Double.parseDouble(zhiTongNum);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setZhiTongNum(String zhiTongNum) {
        this.zhiTongNum = zhiTongNum;
    }

    public String getZhiTongRate() {
        return zhiTongRate;
    }

    public void setZhiTongRate(String zhiTongRate) {
        this.zhiTongRate = zhiTongRate;
    }
}
