package com.ruoyi.testRecord.task;

import com.ruoyi.testRecord.service.ExcelParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("excelProcessingTask")
public class ExcelProcessingTask {
    @Value("${excel.directory.path}")
    private String excelDirectoryPath;

    @Autowired
    private ExcelParserService excelParserService;

    // 每5分钟检查一次新文件
    public void processNewExcelFiles() {
        excelParserService.processDirectory(excelDirectoryPath);
    }
}
