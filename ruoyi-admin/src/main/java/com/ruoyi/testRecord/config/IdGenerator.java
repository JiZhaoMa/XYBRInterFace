package com.ruoyi.testRecord.config;

import java.util.UUID;

public class IdGenerator {
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
