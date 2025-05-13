package com.ruoyi.u9c.domain;

public class ItemLotCodeInfo {
    private String lotId;
    private String itemCode;
    private String lotCode;
    private String preLevel;
    private String isUsed;

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public String getPreLevel() {
        return preLevel;
    }

    public void setPreLevel(String preLevel) {
        this.preLevel = preLevel;
    }
}
