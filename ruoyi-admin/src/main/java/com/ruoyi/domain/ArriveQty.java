package com.ruoyi.domain;

public class ArriveQty {
    private String docNo;
    private String itemCode;
    private int activityQty;

    private String lotCode;

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getActivityQty() {
        return activityQty;
    }

    public void setActivityQty(int activityQty) {
        this.activityQty = activityQty;
    }
}
