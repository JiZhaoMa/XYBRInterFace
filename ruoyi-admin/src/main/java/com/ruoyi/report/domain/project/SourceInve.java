package com.ruoyi.report.domain.project;

public class SourceInve {
    private String year;
    private String month;
    private String sourceType;
    private String inveNum;
    private String projectCode;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getInveNum() {
        return inveNum;
    }

    public void setInveNum(String inveNum) {
        this.inveNum = inveNum;
    }
}
