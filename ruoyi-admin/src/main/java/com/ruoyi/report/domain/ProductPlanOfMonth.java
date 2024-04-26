package com.ruoyi.report.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * 【请填写功能名称】对象 ProductPlanOfMonth
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public class ProductPlanOfMonth extends BaseEntity
{
    private String seriseName;

    private String planMum;

    private String actual;

    private String actualRate;

    public String getSeriseName() {
        return seriseName;
    }

    public void setSeriseName(String seriseName) {
        this.seriseName = seriseName;
    }

    public String getPlanMum() {
        if(planMum == null){
            return "0";
        }else{
            double number = Double.parseDouble(planMum);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setPlanMum(String planMum) {
        this.planMum = planMum;
    }

    public String getActual() {
        if(actual == null){
            return "0";
        }else{
            double number = Double.parseDouble(actual);
            DecimalFormat df = new DecimalFormat("#0");
            return String.valueOf(df.format(number));
        }
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getActualRate() {
        if(actualRate == null){
            return "0.00%";
        }else{
            double number = Double.parseDouble(actualRate);
            DecimalFormat df = new DecimalFormat("#0.00");
            return String.valueOf(df.format(number * 100)) + "%";
        }

    }

    public void setActualRate(String actualRate) {
        this.actualRate = actualRate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private String month;

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    private String agent;

}
