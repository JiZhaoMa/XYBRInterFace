package com.ruoyi.testRecord.service;

import java.util.Set;

public class TestFileChangeListener {
        /*implements FileChangeListener */
    private final TestDataService testDataService;

    public TestFileChangeListener(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

//    @Override
//    public void onChange(Set<ChangedFiles> changeSet) {
//        for (ChangedFiles changedFiles : changeSet) {
//            for (ChangedFile changedFile : changedFiles.getFiles()) {
//                if (changedFile.getType() == ChangedFile.Type.ADD &&
//                        (changedFile.getFile().getName().endsWith(".xls") ||
//                                changedFile.getFile().getName().endsWith(".xlsx"))) {
//
//                    try {
//                        // 等待文件完全写入
//                        Thread.sleep(1000);
//                        testDataService.processTestFile(changedFile.getFile());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
}
