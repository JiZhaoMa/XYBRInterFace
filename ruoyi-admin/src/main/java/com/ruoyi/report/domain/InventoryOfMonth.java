package com.ruoyi.report.domain;

public class InventoryOfMonth {
    private String month;
    private String agent;

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

    public String getInventoryOfMonthNum() {
        return inventoryOfMonthNum;
    }

    public void setInventoryOfMonthNum(String inventoryOfMonthNum) {
        this.inventoryOfMonthNum = inventoryOfMonthNum;
    }

    private String inventoryOfMonthNum;
}
