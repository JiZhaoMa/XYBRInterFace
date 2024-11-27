package com.ruoyi.report.domain.project;

public class Risk {
    private String riskType;
    private int riskNum;
    private String projectCode;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getRiskType() {
        return riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public int getRiskNum() {
        return riskNum;
    }

    public void setRiskNum(int riskNum) {
        this.riskNum = riskNum;
    }
}
