package com.ruoyi.report.domain.project;

public class EcLedger {
    private String ecNo;
    private String approver;
    private String content;
    private String auditorNames;
    private String stateLabel;
    private String effectiveness;
    private String cutInDate;

    private String projectCode;

    public String getEcNo() {
        return ecNo;
    }

    public void setEcNo(String ecNo) {
        this.ecNo = ecNo;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuditorNames() {
        return auditorNames;
    }

    public void setAuditorNames(String auditorNames) {
        this.auditorNames = auditorNames;
    }

    public String getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(String stateLabel) {
        this.stateLabel = stateLabel;
    }

    public String getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(String effectiveness) {
        this.effectiveness = effectiveness;
    }

    public String getCutInDate() {
        return cutInDate;
    }

    public void setCutInDate(String cutInDate) {
        this.cutInDate = cutInDate;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
}
