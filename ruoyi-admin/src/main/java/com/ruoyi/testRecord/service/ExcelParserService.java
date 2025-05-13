package com.ruoyi.testRecord.service;

import com.ruoyi.testRecord.domain.TestFile;
import com.ruoyi.testRecord.domain.TestStep;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ExcelParserService {
    @Autowired
    private TestFileRepository testFileRepository;

    @Autowired
    private TestStepRepository testStepRepository;

    private static final Pattern TEST_PROGRAM_PATTERN =
            Pattern.compile(
                    "测试程序[:：]\\s*" +               // 前缀
                            "([A-Za-z0-9]+)-" +                // 产品编码(第1组)
                            "([A-Za-z0-9]+)-" +                // 工站(第2组)
                            "(?:FCT-?)?" +                     // 可选FCT标记(非捕获)
                            "([A-Za-z0-9]+)" +                 // 版本(第3组)
                            "(?:\\(.*\\))?" +                  // 忽略括号内容
                            "\\s*"                             // 可能的后缀空格
            );
    private static final Pattern BARCODE_PATTERN =
            Pattern.compile("测试条码[:：]\\s*(.*?)($|\\s|\\|)");
    private static final Pattern TEST_RESULT_PATTERN =
            Pattern.compile("测试结果[:：]\\s*(.*?)($|\\s|\\|)");
    private static final Pattern START_TIME_PATTERN =
            Pattern.compile("开始时间[:：]\\s*(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})");
    private static final Pattern TEST_DURATION_PATTERN =
            Pattern.compile("测试时间:(.*)");

    public void processDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path: " + directoryPath);
        }

        File[] files = dir.listFiles((d, name) -> name.endsWith(".xls") || name.endsWith(".xlsx"));
        if (files == null) {
            return;
        }

        Arrays.stream(files)
                .parallel()
                .forEach(this::processFile);
    }

    private void processFile(File file) {
        String fileName = file.getName();
        if (testFileRepository.existsByFileName(fileName)) {
            return; // 已经处理过的文件跳过
        }

        try (FileInputStream fis = new FileInputStream(file)){
            Workbook workbook;
            if (fileName.toLowerCase().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (fileName.toLowerCase().endsWith(".xls")) {
                workbook = new HSSFWorkbook(fis);
            } else {
                throw new IllegalArgumentException("Unsupported file format: " + fileName);
            }
            Sheet sheet = workbook.getSheetAt(0); // 只处理第一个Sheet

            // 解析第一行信息
            Row firstRow = sheet.getRow(0);
            String firstRowText = getCellStringValue(firstRow.getCell(0));

            Matcher programMatcher = TEST_PROGRAM_PATTERN.matcher(firstRowText);
            if (!programMatcher.find()) {
                throw new RuntimeException("Invalid test program format in file: " + fileName);
            }

            String productCode = programMatcher.group(1);
            String testStation = programMatcher.group(2);
            String softwareVersion = programMatcher.group(3);

            Matcher barcodeMatcher = BARCODE_PATTERN.matcher(getCellStringValue(firstRow.getCell(2)));
            Matcher resultMatcher = TEST_RESULT_PATTERN.matcher(getCellStringValue(firstRow.getCell(3)));
            Matcher timeMatcher = START_TIME_PATTERN.matcher(getCellStringValue(firstRow.getCell(4)));
            Matcher durationMatcher = TEST_DURATION_PATTERN.matcher(getCellStringValue(firstRow.getCell(5)));

            TestFile testFile = new TestFile();
            testFile.setFileName(fileName);
            testFile.setProductCode(productCode);
            testFile.setTestStation(testStation);
            testFile.setSoftwareVersion(softwareVersion);

            if (barcodeMatcher.find()) {
                testFile.setBarcode(barcodeMatcher.group(1));
            }
            if (resultMatcher.find()) {
                testFile.setTestResult(resultMatcher.group(1));
            }
            if (timeMatcher.find()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String startTime = timeMatcher.group(1);
                    testFile.setStartTime(sdf.parse(startTime));
                } catch (Exception e) {
                    // 忽略日期解析错误
                }
            }
            if (durationMatcher.find()) {
                try {
                    testFile.setTestDuration(Double.parseDouble(durationMatcher.group(1)));
                } catch (Exception e) {
                    // 忽略数字解析错误
                }
            }

            // 保存主文件信息
            TestFile savedFile = testFileRepository.save(testFile);

            // 解析测试步骤
            parseTestSteps(sheet, savedFile);

        } catch (Exception e) {
            throw new RuntimeException("Failed to process file: " + fileName, e);
        }
    }

    private void parseTestSteps(Sheet sheet, TestFile testFile) {
        List<TestStep> steps = new ArrayList<>();
        TestStep currentStep = null;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            String stepNumber = getCellStringValue(row.getCell(0));
            String testItem = getCellStringValue(row.getCell(1));
            String displayName = getCellStringValue(row.getCell(2));
            String resultSpec = getCellStringValue(row.getCell(3));
            String productResult = getCellStringValue(row.getCell(4));
            String testTime = getCellStringValue(row.getCell(5));

            if (StringUtils.hasText(stepNumber) && StringUtils.hasText(testItem)) {
                // 这是一个新的测试步骤
                currentStep = new TestStep();
                currentStep.setFile(testFile);
                try {
                    currentStep.setStepNumber(Integer.parseInt(stepNumber));
                } catch (NumberFormatException e) {
                    // 忽略步骤编号解析错误
                }
                currentStep.setTestItem(testItem);
                currentStep.setDisplayName(displayName);
                currentStep.setResultSpec(resultSpec);
                currentStep.setProductResult(productResult);
                currentStep.setTestTime(testTime);

                steps.add(currentStep);
            } else if (currentStep != null && StringUtils.hasText(displayName)) {
                // 这是当前测试步骤的详细测试项
                TestStep detailStep = new TestStep();
                detailStep.setFile(testFile);
                detailStep.setParentStep(currentStep);
                detailStep.setDetailName(displayName);
                detailStep.setDetailSpec(resultSpec);
                detailStep.setDetailValue(productResult);

                steps.add(detailStep);
            }
        }

        // 批量保存测试步骤
        testStepRepository.saveAll(steps);
    }

    private String getCellStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
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
