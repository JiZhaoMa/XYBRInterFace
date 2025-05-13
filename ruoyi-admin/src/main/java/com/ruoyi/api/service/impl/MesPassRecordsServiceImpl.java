package com.ruoyi.api.service.impl;

import com.ruoyi.api.domian.MesPassRecords;
import com.ruoyi.api.mapper.MesPassRecordsMapper;
import com.ruoyi.api.service.MesPassRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MesPassRecordsServiceImpl implements MesPassRecordsService {
    @Autowired
    MesPassRecordsMapper mesPassRecordsMapper;
    @Override
    public void insertRecords(List<MesPassRecords> list) {
        mesPassRecordsMapper.insertRecords(list);
    }
}
