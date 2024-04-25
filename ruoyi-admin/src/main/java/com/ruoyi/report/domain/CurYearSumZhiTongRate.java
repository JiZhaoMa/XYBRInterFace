package com.ruoyi.report.domain;

public class CurYearSumZhiTongRate {
    private String startMonth;
    private String endMonth;
    private String agent;
    private String seriesOfSumFirst;
    private String seriesOfSumSecond;
    private String seriesOfSumThird;
    private String seriesOfRateFirst;
    private String seriesOfRateSecond;
    private String seriesOfRateThird;
    private String seriesName;
    private String productSum;

    public String getProductSum() {
        return productSum;
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

    private String zhiTongRate;
    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getSeriesOfSumFirst() {
        return seriesOfSumFirst;
    }

    public void setSeriesOfSumFirst(String seriesOfSumFirst) {
        this.seriesOfSumFirst = seriesOfSumFirst;
    }

    public String getSeriesOfSumSecond() {
        return seriesOfSumSecond;
    }

    public void setSeriesOfSumSecond(String seriesOfSumSecond) {
        this.seriesOfSumSecond = seriesOfSumSecond;
    }

    public String getSeriesOfSumThird() {
        return seriesOfSumThird;
    }

    public void setSeriesOfSumThird(String seriesOfSumThird) {
        this.seriesOfSumThird = seriesOfSumThird;
    }

    public String getSeriesOfRateFirst() {
        return seriesOfRateFirst;
    }

    public void setSeriesOfRateFirst(String seriesOfRateFirst) {
        this.seriesOfRateFirst = seriesOfRateFirst;
    }

    public String getSeriesOfRateSecond() {
        return seriesOfRateSecond;
    }

    public void setSeriesOfRateSecond(String seriesOfRateSecond) {
        this.seriesOfRateSecond = seriesOfRateSecond;
    }

    public String getSeriesOfRateThird() {
        return seriesOfRateThird;
    }

    public void setSeriesOfRateThird(String seriesOfRateThird) {
        this.seriesOfRateThird = seriesOfRateThird;
    }

}
