package com.ruoyi.service;

import com.ruoyi.domain.*;

import java.util.List;

/**
 * @description:调用接口的Service
 * @Author: majizhao
 * @date: 2024/3/13 11:24
 */
public interface InterfaceService {
    public int insertOrderList(List<InterFaceOrder> list);
    public int insertAgentOrderList(List<InterFaceAgentOrder> list);

    public int insertProcessDataList(List<InterFaceProcessData> list);
    public int insertInstoreDataList(List<InterFaceInStoreData> list);
    public int insertShippingDataList(List<InterFaceShippingData> list);
    public int insertStockDataList(List<InterFaceStockData> StockData);
    public int deleteStockData();
    public int insertHistoryStockDataList(List<InterFaceStockData> StockData);
}
