package com.ruoyi.report.domain;

import java.text.DecimalFormat;

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
        if(actInventory == null){
            return actInventory;
        }else{
            double number = Double.parseDouble(actInventory);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
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
