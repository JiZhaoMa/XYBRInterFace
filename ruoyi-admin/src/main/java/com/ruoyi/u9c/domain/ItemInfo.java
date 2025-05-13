package com.ruoyi.u9c.domain;

public class ItemInfo {
    private String code;
    private String name;
    private String specs;
    private String unitName;
    private String unitCode;
    private String categoryCode;

    private String supplier;  //供应商
    private String purchAttr; //采购属性
    private String itemStatus; //编码状态 正式，临时，已认证
    private String sharingRatio; //分摊比
    private String price; //单价
    private String lotCode; //批号
    private String xiaoLeiCode; //小类编码
    private String xiaoleiName; //小类名称
    private String itemDesc; //物料描述
    private String categoryName; //单位名称
    private String itemLevel; //器件等级
    private String rohs;
    private String reach;

    public String getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(String itemLevel) {
        this.itemLevel = itemLevel;
    }

    public String getRohs() {
        return rohs;
    }

    public void setRohs(String rohs) {
        this.rohs = rohs;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getXiaoLeiCode() {
        return xiaoLeiCode;
    }

    public void setXiaoLeiCode(String xiaoLeiCode) {
        this.xiaoLeiCode = xiaoLeiCode;
    }

    public String getXiaoleiName() {
        return xiaoleiName;
    }

    public void setXiaoleiName(String xiaoleiName) {
        this.xiaoleiName = xiaoleiName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public String getSharingRatio() {
        return sharingRatio;
    }

    public void setSharingRatio(String sharingRatio) {
        this.sharingRatio = sharingRatio;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPurchAttr() {
        return purchAttr;
    }

    public void setPurchAttr(String purchAttr) {
        this.purchAttr = purchAttr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
