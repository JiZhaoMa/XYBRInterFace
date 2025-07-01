package com.ruoyi.testRecord.mapper;


import com.ruoyi.testRecord.domain.TestRecord;

import java.util.List;

public interface TestRecordMapper {
    int insert(TestRecord testRecord);
    List<TestRecord> queryFailData(TestRecord testRecord);
    List<String> queryEmails();
    List<String> queryFolder();
    int queryWarningHis(TestRecord testRecord);
    int insertWarningHis(TestRecord testRecord);
}
