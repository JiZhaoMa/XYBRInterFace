package com.ruoyi.report.domain;

import java.text.DecimalFormat;

public class InventoryTurnoverData {
    private String month;
    private String agent;
    private String currentInventoryNum; //当前库存
    private String currYearShipping; //当年发货量

    public String getCurrYearInventory() {
        return currYearInventory;
    }

    public void setCurrYearInventory(String currYearInventory) {
        this.currYearInventory = currYearInventory;
    }

    private String currYearInventory; //当年月末库存之和

    public String getCurrYearShipping() {//////
        if(currYearShipping == null){
            return "0";
        }else{
            double number = Double.parseDouble(currYearShipping);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setCurrYearShipping(String currYearShipping) {
        this.currYearShipping = currYearShipping;
    }

    public String getMonthInventory() {
        return monthInventory;
    }

    public void setMonthInventory(String monthInventory) {
        this.monthInventory = monthInventory;
    }

    private String monthInventory; //月度库存

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

    public String getCurrentInventoryNum() {  ///////
        if(currentInventoryNum == null){
            return "0";
        }else{
            double number = Double.parseDouble(currentInventoryNum);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setCurrentInventoryNum(String currentInventoryNum) {
        this.currentInventoryNum = currentInventoryNum;
    }

    public String getInventoryTurnoverNum() {
        return inventoryTurnoverNum;
    }

    public void setInventoryTurnoverNum(String inventoryTurnoverNum) {
        this.inventoryTurnoverNum = inventoryTurnoverNum;
    }

    private String inventoryTurnoverNum;
}
