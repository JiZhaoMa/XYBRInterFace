package com.ruoyi.u9c.domain;

public class POLine {
    private String DocumentType;
    private String BizType;
    private String BusinessDate;
    private String PurOperCode;
    private String PurDeptCode;
    private String SupplierCode;
    private String TC;
    private String AC;
    private String ItemInfoCode;
    private int ReqQtyTU;
    private int SupplierConfirmQtyTU;
    private String FinallyPriceTC;
    private String TaxScheduleCode;
    private String projectCode;
    private String orderCode;
    private String caiGouType;
    private String lotCode;
    public int DocLineNo;
    public String DeliveryDate;
    public String shipAdress;
    public String serializeNo;

    public String getShipAdress() {
        return shipAdress;
    }

    public void setShipAdress(String shipAdress) {
        this.shipAdress = shipAdress;
    }

    public String getSerializeNo() {
        return serializeNo;
    }

    public void setSerializeNo(String serializeNo) {
        this.serializeNo = serializeNo;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public int getDocLineNo() {
        return DocLineNo;
    }

    public void setDocLineNo(int docLineNo) {
        DocLineNo = docLineNo;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public String getCaiGouType() {
        return caiGouType;
    }

    public void setCaiGouType(String caiGouType) {
        this.caiGouType = caiGouType;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(String documentType) {
        DocumentType = documentType;
    }

    public String getBizType() {
        return BizType;
    }

    public void setBizType(String bizType) {
        BizType = bizType;
    }

    public String getBusinessDate() {
        return BusinessDate;
    }

    public void setBusinessDate(String businessDate) {
        BusinessDate = businessDate;
    }

    public String getPurOperCode() {
        return PurOperCode;
    }

    public void setPurOperCode(String purOperCode) {
        PurOperCode = purOperCode;
    }

    public String getPurDeptCode() {
        return PurDeptCode;
    }

    public void setPurDeptCode(String purDeptCode) {
        PurDeptCode = purDeptCode;
    }

    public String getSupplierCode() {
        return SupplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        SupplierCode = supplierCode;
    }

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getAC() {
        return AC;
    }

    public void setAC(String AC) {
        this.AC = AC;
    }

    public String getItemInfoCode() {
        return ItemInfoCode;
    }

    public void setItemInfoCode(String itemInfoCode) {
        ItemInfoCode = itemInfoCode;
    }

    public int getReqQtyTU() {
        return ReqQtyTU;
    }

    public void setReqQtyTU(int reqQtyTU) {
        ReqQtyTU = reqQtyTU;
    }

    public int getSupplierConfirmQtyTU() {
        return SupplierConfirmQtyTU;
    }

    public void setSupplierConfirmQtyTU(int supplierConfirmQtyTU) {
        SupplierConfirmQtyTU = supplierConfirmQtyTU;
    }

    public String getFinallyPriceTC() {
        return FinallyPriceTC;
    }

    public void setFinallyPriceTC(String finallyPriceTC) {
        FinallyPriceTC = finallyPriceTC;
    }

    public String getTaxScheduleCode() {
        return TaxScheduleCode;
    }

    public void setTaxScheduleCode(String taxScheduleCode) {
        TaxScheduleCode = taxScheduleCode;
    }
}
