package com.ruoyi.testRecord.domain;

import com.ruoyi.testRecord.config.IdGenerator;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class TestStep {
    private String id;
    private String testRecordId;
    private String stepNumber;
    private String testItem;
    private String displayName;
    private String specRange;
    private String result;
    private String testTime;
    private String dataType;    // MAIN或DETAIL
    private String rawData;     // 存储详细数据的JSON
    private String parentStepId;
    private List<TestStep> details; // 子步骤列表

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getParentStepId() {
        return parentStepId;
    }

    public void setParentStepId(String parentStepId) {
        this.parentStepId = parentStepId;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public List<TestStep> getDetails() {
        return details;
    }

    public void setDetails(List<TestStep> details) {
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestRecordId() {
        return testRecordId;
    }

    public void setTestRecordId(String testRecordId) {
        this.testRecordId = testRecordId;
    }

    public String getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(String stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSpecRange() {
        return specRange;
    }

    public void setSpecRange(String specRange) {
        this.specRange = specRange;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }
}