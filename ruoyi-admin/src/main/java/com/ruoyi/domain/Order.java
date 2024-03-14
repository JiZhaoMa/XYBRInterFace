package com.ruoyi.domain;

/*
 *
 * @author: majizhao
 * @date: 2024/3/13 10:53
 * @return: null
 * @throws:
 **/
public class Order {
    private String productCode; // 产品编码
    private String xybrOrderNo; // 星源订单号
    private String agentOrderNo; // 代工厂订单号
    private int orderNum; // 订单数量
    private String orderOnlineDate; // 订单上线时间
    private String smtNum; // SMT过站数量
    private String chaJianNum; //插件过站数量
    private String ftNum; //FT过站数量
    private String zhongYanNum; //单板终验过站数量
    private String zuZhuangNum; //单板组装过站数量
    private String zhengJiNum; //整机组装过站数量
    private String laoHuaQianNum; //老化前过站数量
    private String laoHuaNum; //老化过站数量
    private String laoHuaHouNum; //老化后过站数量
    private String inBound; //入库数量
    private String agentName; //代理商
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getXybrOrderNo() {
        return xybrOrderNo;
    }

    public void setXybrOrderNo(String xybrOrderNo) {
        this.xybrOrderNo = xybrOrderNo;
    }

    public String getAgentOrderNo() {
        return agentOrderNo;
    }

    public void setAgentOrderNo(String agentOrderNo) {
        this.agentOrderNo = agentOrderNo;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderOnlineDate() {
        return orderOnlineDate;
    }

    public void setOrderOnlineDate(String orderOnlineDate) {
        this.orderOnlineDate = orderOnlineDate;
    }

    public String getSmtNum() {
        return smtNum;
    }

    public void setSmtNum(String smtNum) {
        this.smtNum = smtNum;
    }

    public String getChaJianNum() {
        return chaJianNum;
    }

    public void setChaJianNum(String chaJianNum) {
        this.chaJianNum = chaJianNum;
    }

    public String getFtNum() {
        return ftNum;
    }

    public void setFtNum(String ftNum) {
        this.ftNum = ftNum;
    }

    public String getZhongYanNum() {
        return zhongYanNum;
    }

    public void setZhongYanNum(String zhongYanNum) {
        this.zhongYanNum = zhongYanNum;
    }

    public String getZuZhuangNum() {
        return zuZhuangNum;
    }

    public void setZuZhuangNum(String zuZhuangNum) {
        this.zuZhuangNum = zuZhuangNum;
    }

    public String getZhengJiNum() {
        return zhengJiNum;
    }

    public void setZhengJiNum(String zhengJiNum) {
        this.zhengJiNum = zhengJiNum;
    }

    public String getLaoHuaQianNum() {
        return laoHuaQianNum;
    }

    public void setLaoHuaQianNum(String laoHuaQianNum) {
        this.laoHuaQianNum = laoHuaQianNum;
    }

    public String getLaoHuaNum() {
        return laoHuaNum;
    }

    public void setLaoHuaNum(String laoHuaNum) {
        this.laoHuaNum = laoHuaNum;
    }

    public String getLaoHuaNumHou() {
        return laoHuaHouNum;
    }

    public void setLaoHuaNumHou(String laoHuaNumHou) {
        this.laoHuaHouNum = laoHuaNumHou;
    }

    public String getInBound() {
        return inBound;
    }

    public void setInBound(String inBound) {
        this.inBound = inBound;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

}
