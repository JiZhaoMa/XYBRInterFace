package com.ruoyi.api.domian;

public class Product {
    private String ReciveDate;
    private String ItemCode;
    private String PO;
    private int POLineNo;
    private int ReciveNum;
    private String Fact;

    public int getPOLineNo() {
        return POLineNo;
    }

    public void setPOLineNo(int POLineNo) {
        this.POLineNo = POLineNo;
    }

    public String getReciveDate() {
        return ReciveDate;
    }

    public void setReciveDate(String reciveDate) {
        ReciveDate = reciveDate;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public int getReciveNum() {
        return ReciveNum;
    }

    public void setReciveNum(int reciveNum) {
        ReciveNum = reciveNum;
    }

    public String getFact() {
        return Fact;
    }

    public void setFact(String fact) {
        Fact = fact;
    }
}
