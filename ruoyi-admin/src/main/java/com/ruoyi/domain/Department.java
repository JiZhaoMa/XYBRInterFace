package com.ruoyi.domain;

public class Department {
    private String dingDingCode;
    private String u9cCode;
    private String deptId;
    private String deptName;
    private String parentdept;
    private String parentU9cCode;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getU9cCode() {
        return u9cCode;
    }

    public void setU9cCode(String u9cCode) {
        this.u9cCode = u9cCode;
    }

    public String getParentU9cCode() {
        return parentU9cCode;
    }

    public void setParentU9cCode(String parentU9cCode) {
        this.parentU9cCode = parentU9cCode;
    }

    public String getDingDingCode() {
        return dingDingCode;
    }

    public void setDingDingCode(String dingDingCode) {
        this.dingDingCode = dingDingCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentdept() {
        return parentdept;
    }

    public void setParentdept(String parentdept) {
        this.parentdept = parentdept;
    }
}
