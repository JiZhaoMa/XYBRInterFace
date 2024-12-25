package com.ruoyi.api.domian;

public class Material {
    private String ReciveDate;
    private String ItemCode;
    private String Suppier;
    private int ReciveNum;
    private int ReqQtyTU;
    private int RcvQtyCU;
    private String DocNo;
    private String DocLineNo;
    private String Fact;
    private String BusinessDate;

    public String getBusinessDate() {
        return BusinessDate;
    }

    public void setBusinessDate(String businessDate) {
        BusinessDate = businessDate;
    }

    public String getDocNo() {
        return DocNo;
    }

    public void setDocNo(String docNo) {
        DocNo = docNo;
    }

    public String getDocLineNo() {
        return DocLineNo;
    }

    public void setDocLineNo(String docLineNo) {
        DocLineNo = docLineNo;
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

    public String getSuppier() {
        return Suppier;
    }

    public void setSuppier(String suppier) {
        Suppier = suppier;
    }

    public int getReciveNum() {
        return ReciveNum;
    }

    public void setReciveNum(int reciveNum) {
        ReciveNum = reciveNum;
    }

    public int getReqQtyTU() {
        return ReqQtyTU;
    }

    public void setReqQtyTU(int reqQtyTU) {
        ReqQtyTU = reqQtyTU;
    }

    public int getRcvQtyCU() {
        return RcvQtyCU;
    }

    public void setRcvQtyCU(int rcvQtyCU) {
        RcvQtyCU = rcvQtyCU;
    }

    public String getFact() {
        return Fact;
    }

    public void setFact(String fact) {
        Fact = fact;
    }
}
