package com.ruoyi.report.domain.project;

public class EcLedger {
    private String ecNo;
    private String appDate;
    private String approver;
    private String content;
    private String inVolveNewItem;
    private String affectedProduct;
    private String keyDevices;
    private String affectedPcn;
    private String orderNo;
    private String effectiveness;
    private String cutInDate;
    private String firstBarCode;
    private String notes;
    private String projectCode;

    public String getCutInDate() {
        return cutInDate;
    }

    public void setCutInDate(String cutInDate) {
        this.cutInDate = cutInDate;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getEcNo() {
        return ecNo;
    }

    public void setEcNo(String ecNo) {
        this.ecNo = ecNo;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInVolveNewItem() {
        return inVolveNewItem;
    }

    public void setInVolveNewItem(String inVolveNewItem) {
        this.inVolveNewItem = inVolveNewItem;
    }

    public String getAffectedProduct() {
        return affectedProduct;
    }

    public void setAffectedProduct(String affectedProduct) {
        this.affectedProduct = affectedProduct;
    }

    public String getKeyDevices() {
        return keyDevices;
    }

    public void setKeyDevices(String keyDevices) {
        this.keyDevices = keyDevices;
    }

    public String getAffectedPcn() {
        return affectedPcn;
    }

    public void setAffectedPcn(String affectedPcn) {
        this.affectedPcn = affectedPcn;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(String effectiveness) {
        this.effectiveness = effectiveness;
    }

    public String getFirstBarCode() {
        return firstBarCode;
    }

    public void setFirstBarCode(String firstBarCode) {
        this.firstBarCode = firstBarCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
