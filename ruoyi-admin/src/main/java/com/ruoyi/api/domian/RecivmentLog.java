package com.ruoyi.api.domian;

public class RecivmentLog {
    private String ItemCode;
    private String Suppier;
    private String ReciveDate;
    private int ReciveNum;
    private int ActRecivmentNum;
    private String PONo;
    private int POLineNo;
    private String Result;
    private String Fact;

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getSuppier() {
        return Suppier;
    }

    public void setSuppier(String suppier) {
        Suppier = suppier;
    }

    public String getReciveDate() {
        return ReciveDate;
    }

    public void setReciveDate(String reciveDate) {
        ReciveDate = reciveDate;
    }

    public int getReciveNum() {
        return ReciveNum;
    }

    public void setReciveNum(int reciveNum) {
        ReciveNum = reciveNum;
    }

    public int getActRecivmentNum() {
        return ActRecivmentNum;
    }

    public void setActRecivmentNum(int actRecivmentNum) {
        ActRecivmentNum = actRecivmentNum;
    }

    public String getPONo() {
        return PONo;
    }

    public void setPONo(String PONo) {
        this.PONo = PONo;
    }

    public int getPOLineNo() {
        return POLineNo;
    }

    public void setPOLineNo(int POLineNo) {
        this.POLineNo = POLineNo;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getFact() {
        return Fact;
    }

    public void setFact(String fact) {
        Fact = fact;
    }
}
