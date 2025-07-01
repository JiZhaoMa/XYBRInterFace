package com.ruoyi.testRecord.service;

import com.ruoyi.api.util.Mail;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.domain.PatentRemind;
import com.ruoyi.testRecord.config.IdGenerator;
import com.ruoyi.testRecord.domain.TestRecord;
import com.ruoyi.testRecord.domain.TestStep;
import com.ruoyi.testRecord.mapper.TestRecordMapper;
import com.ruoyi.testRecord.mapper.TestStepMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@DataSource(value = DataSourceType.SLAVE)
@Service
public class TestDataService {
    @Autowired
    private TestRecordMapper testRecordMapper;

    @Autowired
    private TestStepMapper testStepMapper;

    @Autowired
    private ExcelParserService excelParserService;
    @Autowired
    Mail mail;
    @Transactional
    public void processTestFile(File file) {
        TestRecord record = excelParserService.parseExcelFile(file);
        if (record == null) {
            return;
        }
        testRecordMapper.insert(record);

        if (record.getSteps() != null && !record.getSteps().isEmpty()) {
            testStepMapper.insert(record.getSteps());
        }
        if(record.getTestResult().equals("FAIL") && !record.getFailItem().isEmpty()){
            List<TestRecord> list = testRecordMapper.queryFailData(record);
            if(list.size() > 2){
                int isSend = testRecordMapper.queryWarningHis(list.get(0));
                if(isSend <= 0){
                    StringBuilder tableHtml = new StringBuilder();
                    tableHtml.append("<table border='1'>");
                    tableHtml.append("<tr>");
                    tableHtml.append("<td>").append("工厂").append("</td>");
                    tableHtml.append("<td>").append("项目").append("</td>");
                    tableHtml.append("<td>").append("条码").append("</td>");
                    tableHtml.append("<td>").append("测试时间").append("</td>");
                    tableHtml.append("<td>").append("测试程序").append("</td>");
                    tableHtml.append("<td>").append("测试项目").append("</td>");
                    tableHtml.append("<td>").append("文件路径").append("</td>");
                    tableHtml.append("</tr>");
                    for(TestRecord testRecord : list){
                        tableHtml.append("<tr>");
                        tableHtml.append("<td>").append(testRecord.getFact()).append("</td>");
                        tableHtml.append("<td>").append(testRecord.getProject()).append("</td>");
                        tableHtml.append("<td>").append(testRecord.getBarcode()).append("</td>");
                        tableHtml.append("<td>").append(testRecord.getStartTime()).append("</td>");
                        tableHtml.append("<td>").append(testRecord.getTestProgram()).append("</td>");
                        tableHtml.append("<td>").append(testRecord.getTestItem()).append("</td>");
                        tableHtml.append("<td>").append(testRecord.getFilePath()).append("</td>");
                        tableHtml.append("</tr>");
                    }
                    tableHtml.append("</table>");
                    String emailContent = "<html><body><h3 style='color:red'>产品信息：" + list.get(0).getProject() + "-" + list.get(0).getProductCode() + ": </br>异常项目： “" +list.get(0).getTestItem() +"” </br>异常数量：过去一周出现" + list.size() + "例测试失败，请及时关注！！！</h3>" +
                            tableHtml.toString() +
                            "</body></html>";
                    List<String> emailList = testRecordMapper.queryEmails();
                    if(!emailList.isEmpty()){
                        mail.sendMailToList(emailList,"生产质量预警！",emailContent);
                        testRecordMapper.insertWarningHis(list.get(0));
                    }
                }
            }
        }
    }

    public List<String> queryFolder(){
        List<String> folders = testRecordMapper.queryFolder();
        return folders;
    }
}