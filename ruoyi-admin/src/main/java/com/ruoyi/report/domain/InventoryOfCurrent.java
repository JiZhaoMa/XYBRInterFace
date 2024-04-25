package com.ruoyi.report.domain;

public class InventoryOfCurrent {
    private String month;
    private String agent;
    private String productName;
    private String actInventory;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getActInventory() {
        return actInventory;
    }

    public void setActInventory(String actInventory) {
        this.actInventory = actInventory;
    }

    public String getSafeInventory() {
        return safeInventory;
    }

    public void setSafeInventory(String safeInventory) {
        this.safeInventory = safeInventory;
    }

    private String safeInventory;
}
