package com.ruoyi.report.domain.project;

public class ProjectChange {
    private String approver;
    private String stateLabel;
    private String changeType;
    private String changeReason;
    private String approveType;
    private String auditorNames;
    private String changeApprove;
    private String projectCode;

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getStateLabel() {
        return stateLabel;
    }

    public void setStateLabel(String stateLabel) {
        this.stateLabel = stateLabel;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public String getApproveType() {
        return approveType;
    }

    public void setApproveType(String approveType) {
        this.approveType = approveType;
    }

    public String getAuditorNames() {
        return auditorNames;
    }

    public void setAuditorNames(String auditorNames) {
        this.auditorNames = auditorNames;
    }

    public String getChangeApprove() {
        return changeApprove;
    }

    public void setChangeApprove(String changeApprove) {
        this.changeApprove = changeApprove;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
}
