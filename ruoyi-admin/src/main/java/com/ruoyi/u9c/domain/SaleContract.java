package com.ruoyi.u9c.domain;

public class SaleContract {
    private String docNo;
    private String businessDate;
    private String itemName;
    private int orderPrice;
    private int contactQtyPU;
    private int totalMnyTC;
    private String customerName;
    private int deliverQty;

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getContactQtyPU() {
        return contactQtyPU;
    }

    public void setContactQtyPU(int contactQtyPU) {
        this.contactQtyPU = contactQtyPU;
    }

    public int getTotalMnyTC() {
        return totalMnyTC;
    }

    public void setTotalMnyTC(int totalMnyTC) {
        this.totalMnyTC = totalMnyTC;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getDeliverQty() {
        return deliverQty;
    }

    public void setDeliverQty(int deliverQty) {
        this.deliverQty = deliverQty;
    }
}
