package com.ruoyi.testRecord.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "file.monitor")
@Data // Lombok 注解，自动生成getter/setter
public class FileMonitorConfig {
    private List<String> folders;
}