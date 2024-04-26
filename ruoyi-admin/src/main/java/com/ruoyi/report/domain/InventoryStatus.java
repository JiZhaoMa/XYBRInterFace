package com.ruoyi.report.domain;

import java.text.DecimalFormat;

public class InventoryStatus {
    private String month;
    private String agent;
    private String productCode;
    private String productName;
    private String inventory;
    private String hardwareVersion;

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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInventory() {
        if(inventory == null){
            return inventory;
        }else{
            double number = Double.parseDouble(inventory);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    private String softVersion;
}
