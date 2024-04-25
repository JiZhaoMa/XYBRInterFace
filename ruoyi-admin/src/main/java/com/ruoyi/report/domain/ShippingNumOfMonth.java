package com.ruoyi.report.domain;

import java.util.List;

public class ShippingNumOfMonth {
    private String month;
    private String agent;
    private String seriseName;

    public List<String> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<String> monthList) {
        this.monthList = monthList;
    }

    private List<String> monthList;

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

    public String getSeriseName() {
        return seriseName;
    }

    public void setSeriseName(String seriseName) {
        this.seriseName = seriseName;
    }

    public String getFaHuoNum() {
        return faHuoNum;
    }

    public void setFaHuoNum(String faHuoNum) {
        this.faHuoNum = faHuoNum;
    }

    private String faHuoNum;
}
