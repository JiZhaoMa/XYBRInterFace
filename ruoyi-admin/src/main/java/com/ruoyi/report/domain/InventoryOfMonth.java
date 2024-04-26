package com.ruoyi.report.domain;

import java.text.DecimalFormat;

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
        if(inventoryOfMonthNum == null){
            return inventoryOfMonthNum;
        }else{
            double number = Double.parseDouble(inventoryOfMonthNum);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setInventoryOfMonthNum(String inventoryOfMonthNum) {
        this.inventoryOfMonthNum = inventoryOfMonthNum;
    }

    private String inventoryOfMonthNum;
}
