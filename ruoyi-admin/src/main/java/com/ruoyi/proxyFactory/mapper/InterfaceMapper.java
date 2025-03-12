package com.ruoyi.proxyFactory.mapper;

import com.ruoyi.proxyFactory.domain.*;
import java.util.List;

/**
 * @description:
 * @Author: majizhao
 * @date: 2024/3/13 11:28
 */
public interface InterfaceMapper {
    public int insertOrderList(List<InterFaceOrder> list);
    public int insertAgentOrderList(List<InterFaceAgentOrder> list);
    public int insertProcessDataList(List<InterFaceProcessData> list);
    public int insertInstoreDataList(List<InterFaceInStoreData> list);
    public int insertShippingDataList(List<InterFaceShippingData> list);
    public int insertStockDataList(List<InterFaceStockData> list);
    public int deleteStockData();
    public int insertHistoryStockDataList(List<InterFaceStockData> list);
    public List<InterFaceDomain> getInterFaceList(InterFaceDomain interFaceDomain);
}
