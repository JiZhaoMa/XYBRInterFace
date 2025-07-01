package com.ruoyi.testRecord.service;


import com.ruoyi.testRecord.domain.TestRecord;

import java.io.File;

public interface ExcelParserService {
    TestRecord parseExcelFile(File file);
}
