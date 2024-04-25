package com.ruoyi.service.impl;

import com.ruoyi.domain.*;
import com.ruoyi.mapper.InterfaceMapper;
import com.ruoyi.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:API接口实现类
 * @Author: majizhao
 * @date: 2024/3/13 11:26
 */
@Service
public class InterfaceServiceImpl implements InterfaceService{
    @Autowired
    private InterfaceMapper interfaceMapper;
    @Override
    public int insertOrderList(List<InterFaceOrder> list) {
        return interfaceMapper.insertOrderList(list);
    }

    @Override
    public int insertAgentOrderList(List<InterFaceAgentOrder> list) {
        return interfaceMapper.insertAgentOrderList(list);
    }

    @Override
    public int insertProcessDataList(List<InterFaceProcessData> list) {
        return interfaceMapper.insertProcessDataList(list);
    }

    @Override
    public int insertInstoreDataList(List<InterFaceInStoreData> list) {
        return interfaceMapper.insertInstoreDataList(list);
    }

    @Override
    public int insertShippingDataList(List<InterFaceShippingData> list) {
        return interfaceMapper.insertShippingDataList(list);
    }

    @Override
    public int insertStockDataList(List<InterFaceStockData> list) {
        return interfaceMapper.insertStockDataList(list);
    }

    @Override
    public int deleteStockData() {
        return interfaceMapper.deleteStockData();
    }

    @Override
    public int insertHistoryStockDataList(List<InterFaceStockData> list) {
        return interfaceMapper.insertHistoryStockDataList(list);
    }
}
