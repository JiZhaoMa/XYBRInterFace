package com.ruoyi.report.domain;

public class MonthPlan {
    private String plan;
    private String finshRate;
    private String agent;

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getFinshRate() {
        return finshRate;
    }

    public void setFinshRate(String finshRate) {
        this.finshRate = finshRate;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private String month;
}
