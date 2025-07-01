package com.ruoyi.testRecord.service.impl;
import com.ruoyi.testRecord.config.FileMonitorConfig;
import com.ruoyi.testRecord.mapper.TestRecordMapper;
import com.ruoyi.testRecord.service.FileWatcherService;
import com.ruoyi.testRecord.service.TestDataService;
import com.ruoyi.testRecord.service.TestFileChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.devtools.filewatch.FileSystemWatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.time.Duration;
import java.util.List;

/*
@Service
*/
public class FileWatcherServiceImpl implements FileWatcherService {
    @Autowired
    private FileMonitorConfig config;

    @Autowired
    private TestDataService testDataService;

    private FileSystemWatcher fileSystemWatcher;
    @Autowired
    private TestRecordMapper testRecordMapper;

    /*@PostConstruct*/
    @Override
    public void startWatching() {
        fileSystemWatcher = new FileSystemWatcher(true, Duration.ofMillis(2000), Duration.ofMillis(1000));
        List<String> foldersToWatch = testRecordMapper.queryFolder();
        for (String folderPath : foldersToWatch) {
            File folder = new File(folderPath);
            if (folder.exists()) {
                fileSystemWatcher.addSourceFolder(folder);
                System.out.println("开始监控文件夹: " + folderPath);
            } else {
                System.err.println("文件夹不存在: " + folderPath);
            }
        }

        /*fileSystemWatcher.addListener(new TestFileChangeListener(testDataService));*/
        fileSystemWatcher.start();
    }

    /*@PreDestroy*/
    @Override
    public void stopWatching() {
        if (fileSystemWatcher != null) {
            fileSystemWatcher.stop();
        }
    }
}
