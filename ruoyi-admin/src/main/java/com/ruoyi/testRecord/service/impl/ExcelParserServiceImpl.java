package com.ruoyi.testRecord.service.impl;
import com.ruoyi.testRecord.config.IdGenerator;
import com.ruoyi.testRecord.domain.TestRecord;
import com.ruoyi.testRecord.domain.TestStep;
import com.ruoyi.testRecord.service.ExcelParserService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelParserServiceImpl implements ExcelParserService {
    @Override
    public TestRecord parseExcelFile(File file) {
        String recordId = IdGenerator.uuid();
        String stepId = "";
        String detailsId = "";
        String failItem = "";
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            // Parse header row
            Row headerRow = sheet.getRow(0);
            String testProgram = getCellValue(headerRow.getCell(0)).split(":")[1].trim();
            String barcode = getCellValue(headerRow.getCell(2)).split(":")[1].trim();
            String testResult = getCellValue(headerRow.getCell(3)).split(":")[1].trim();
            String startTimeStr = getCellValue(headerRow.getCell(4)).split("开始时间:")[1].trim();
            double testDuration = Double.parseDouble(
                    getCellValue(headerRow.getCell(5)).split(":")[1].trim());

            // Parse product code and test station
            String[] programParts = testProgram.split("-");
            String productCode = programParts[0];
            String testStation = null;
            for (int i = 1; i < programParts.length; i++) {
                if (programParts[i].matches("[TMUF]\\d")) {
                    testStation = programParts[i];
                    break;
                }
            }

            // Parse test steps
            List<TestStep> steps = new ArrayList<>();
            boolean stopParsing = false;

            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                /*if (row == null || row.getCell(0) == null ||
                        getCellValue(row.getCell(0)).isEmpty()) {
                    continue;
                }*/

                TestStep step = new TestStep();
                String stepNumStr = getCellValue(row.getCell(0));
                String testItem = getCellValue(row.getCell(1));
                if(stepNumStr.isEmpty() && testItem.isEmpty()){
                    step.setParentStepId(stepId);
                }
                step.setId(detailsId);
                step.setTestRecordId(recordId);
                stepId = IdGenerator.uuid();
                step.setId(stepId);
                step.setStepNumber(stepNumStr);
                step.setTestItem(testItem);
                step.setDisplayName(getCellValue(row.getCell(2)));
                step.setSpecRange(getCellValue(row.getCell(3)));
                step.setResult(getCellValue(row.getCell(4)));
                step.setTestTime(getCellValue(row.getCell(5)));
                step.setTestRecordId(recordId);
                steps.add(step);
                if (testResult.equals("FAIL") && step.getResult() != null &&
                        step.getResult().equals("FAIL")) {
                    if(stepNumStr.isEmpty() && testItem.isEmpty()){
                        failItem = step.getParentStepId();
                    }else{
                        failItem = step.getId();
                    }
                    stopParsing = true;
                    break;
                }
            }

            TestRecord record = new TestRecord();
            record.setFailItem(failItem);
            record.setId(recordId);
            record.setTestProgram(testProgram);
            record.setProductCode(productCode);
            record.setTestStation(testStation);
            record.setBarcode(barcode);
            record.setTestResult(testResult);
            record.setStartTime(LocalDateTime.parse(startTimeStr,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            record.setTestDuration(testDuration);
            record.setFilePath(file.getAbsolutePath());
            String fact = "";
            if(file.getAbsolutePath().contains("SLDATA")){
                record.setFact("四联");
            }else if(file.getAbsolutePath().contains("TBDATA")){
                record.setFact("天宝");
            }else if(file.getAbsolutePath().contains("ZRYDATA")){
                record.setFact("卓瑞源");
            }else{
                record.setFact("星源博瑞");
            }
            record.setSteps(steps);

            return record;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getLocalDateTimeCellValue().toString();
                } else {
                    return String.valueOf((int) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}