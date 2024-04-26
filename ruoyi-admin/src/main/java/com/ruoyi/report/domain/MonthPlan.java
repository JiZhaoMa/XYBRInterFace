package com.ruoyi.report.domain;

import java.text.DecimalFormat;

public class MonthPlan {
    private String plan;
    private String finshRate;
    private String agent;
    private String finish;
    public String getFinish() {
        double number = Double.parseDouble(finish);
        DecimalFormat df = new DecimalFormat("#0");
        return String.valueOf(df.format(number));
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }
    public String getPlan() {
        double number = Double.parseDouble(plan);
        DecimalFormat df = new DecimalFormat("#0");
        return String.valueOf(df.format(number));
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
