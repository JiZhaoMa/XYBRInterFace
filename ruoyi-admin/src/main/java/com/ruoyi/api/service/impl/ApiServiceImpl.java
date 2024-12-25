package com.ruoyi.api.service.impl;

import com.ruoyi.api.domian.RecivmentLog;
import com.ruoyi.api.mapper.ApiMapper;
import com.ruoyi.api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    ApiMapper apiMapper;
    @Override
    public int insertRecivmentLog(RecivmentLog recivmentLog) {
        return apiMapper.insertRecivmentLog(recivmentLog);
    }
}
