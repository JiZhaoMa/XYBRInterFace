package com.ruoyi.testRecord.controller;

import com.ruoyi.testRecord.mapper.TestRecordMapper;
import com.ruoyi.testRecord.service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Controller
@RequestMapping("/interface/testRecord")
public class TestRecordController {
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 6;
    @Autowired
    TestDataService testDataService;
    @Autowired
    TestRecordMapper testRecordMapper;
    @GetMapping("/getAssetCode/{hours}")
    @ResponseBody
    public void queryList(@PathVariable("hours")Integer hours) throws InterruptedException {
        List<String> folders = testRecordMapper.queryFolder();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        CountDownLatch latch = new CountDownLatch(1); // 用于等待所有任务完成
        Instant cutoffTime = Instant.now().minus(hours, ChronoUnit.HOURS);
        for (String folder : folders) {
            try (Stream<Path> paths = Files.walk(Paths.get(folder))) {
                paths.filter(Files::isRegularFile)
                        .filter(path -> {
                            try {
                                // 只保留7天内修改过的文件
                                Instant lastModifiedTime = Files.getLastModifiedTime(path).toInstant();
                                return lastModifiedTime.isAfter(cutoffTime);
                            } catch (IOException e) {
                                System.err.println("无法获取文件修改时间: " + path);
                                return false;
                            }
                        })
                        .forEach(file -> {
                            executor.submit(() -> processFile(file.toString()));
                        });
            } catch (IOException e) {
                System.err.println("Error reading folder: " + folder);
                e.printStackTrace();
            }
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS); // 等待所有任务完成
    }
    private void processFile(String filePath) {
        File file = new File(filePath);
        testDataService.processTestFile(file);
    }
}
