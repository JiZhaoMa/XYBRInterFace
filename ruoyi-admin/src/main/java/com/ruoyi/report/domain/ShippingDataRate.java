package com.ruoyi.report.domain;

import java.text.DecimalFormat;

public class ShippingDataRate {
    private String SERISE;

    public String getNum() {
        if(num == null){
            return num;
        }else{
            double number = Double.parseDouble(num);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setNum(String num) {
        this.num = num;
    }

    private String num;

    public String getSERISE() {
        return SERISE;
    }

    public void setSERISE(String SERISE) {
        this.SERISE = SERISE;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    private String agent;
}
