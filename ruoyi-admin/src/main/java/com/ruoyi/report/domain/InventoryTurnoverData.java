package com.ruoyi.report.domain;

public class InventoryTurnoverData {
    private String month;
    private String agent;
    private String currentInventoryNum;
    private String currYearShipping;

    public String getCurrYearInventory() {
        return currYearInventory;
    }

    public void setCurrYearInventory(String currYearInventory) {
        this.currYearInventory = currYearInventory;
    }

    private String currYearInventory;

    public String getCurrYearShipping() {
        return currYearShipping;
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

    private String monthInventory;

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

    public String getCurrentInventoryNum() {
        return currentInventoryNum;
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
