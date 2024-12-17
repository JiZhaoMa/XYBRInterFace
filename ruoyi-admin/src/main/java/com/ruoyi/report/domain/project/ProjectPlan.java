package com.ruoyi.report.domain.project;

public class ProjectPlan {
    private String projectCode;
    private String projectName;
    private String processName;
    private int processValue;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public int getProcessValue() {
        return processValue;
    }

    public void setProcessValue(int processValue) {
        this.processValue = processValue;
    }
}
