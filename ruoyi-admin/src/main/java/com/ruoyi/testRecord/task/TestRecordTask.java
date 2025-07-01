package com.ruoyi.testRecord.task;

import com.ruoyi.testRecord.mapper.TestRecordMapper;
import com.ruoyi.testRecord.service.TestDataService;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;
import java.io.File;
@Component("testRecordTask")
public class TestRecordTask {
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 6;
    @Autowired
    TestDataService testDataService;
    @Autowired
    TestRecordMapper testRecordMapper;
    public void queryList(Integer hours) throws InterruptedException {
        List<String> folders = testDataService.queryFolder();
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
