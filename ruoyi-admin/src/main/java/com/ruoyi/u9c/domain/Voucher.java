package com.ruoyi.u9c.domain;

/*
费用
 */
public class Voucher {
    private int salesMoney; //销售费用
    private int ManageMoney; //管理费用
    private int rdmMoney; //研发费用
    private String month; //月份
    private int money;
    private String type;
    private float percent;
    private int sumMoney;

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSalesMoney() {
        return salesMoney;
    }

    public void setSalesMoney(int salesMoney) {
        this.salesMoney = salesMoney;
    }

    public int getManageMoney() {
        return ManageMoney;
    }

    public void setManageMoney(int manageMoney) {
        ManageMoney = manageMoney;
    }

    public int getRdmMoney() {
        return rdmMoney;
    }

    public void setRdmMoney(int rdmMoney) {
        this.rdmMoney = rdmMoney;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
