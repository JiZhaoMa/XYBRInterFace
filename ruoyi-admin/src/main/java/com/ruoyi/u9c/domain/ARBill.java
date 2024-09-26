package com.ruoyi.u9c.domain;

/*
应收单
 */
public class ARBill {
    private int totalMoney; //金额
    private String shortName; //简称
    private String accrueCustCode; //客户编号
    private String year;
    private String month;
    private String territory; //地区
    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAccrueCustCode() {
        return accrueCustCode;
    }

    public void setAccrueCustCode(String accrueCustCode) {
        this.accrueCustCode = accrueCustCode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }
}
