package com.ruoyi.report.domain;

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
        return testNum;
    }

    public void setTestNum(String testNum) {
        this.testNum = testNum;
    }

    public String getZhiTongNum() {
        return zhiTongNum;
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
