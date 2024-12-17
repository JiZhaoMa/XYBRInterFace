package com.ruoyi.api.service;

import java.util.List;

import com.ruoyi.api.domian.OrderPlatInfo;

/**
 * 平台Service接口
 *
 * @author kyrie
 * @date 2024-03-15
 */
public interface IOrderPlatInfoService {
    /**
     * 查询平台
     *
     * @param id 平台主键
     * @return 平台
     */
    OrderPlatInfo selectOrderPlatInfoById(Long id);

    /**
     * 查询平台列表
     *
     * @param orderPlatInfo 平台
     * @return 平台集合
     */
    List<OrderPlatInfo> selectOrderPlatInfoList(OrderPlatInfo orderPlatInfo);

    /**
     * 新增平台
     *
     * @param orderPlatInfo 平台
     * @return 结果
     */
    int insertOrderPlatInfo(OrderPlatInfo orderPlatInfo);

    /**
     * 修改平台
     *
     * @param orderPlatInfo 平台
     * @return 结果
     */
    int updateOrderPlatInfo(OrderPlatInfo orderPlatInfo);

    /**
     * 批量删除平台
     *
     * @param ids 需要删除的平台主键集合
     * @return 结果
     */
    int deleteOrderPlatInfoByIds(Long[] ids);

    /**
     * 删除平台信息
     *
     * @param id 平台主键
     * @return 结果
     */
    int deleteOrderPlatInfoById(Long id);

    /**
     * 查询平台
     * @param appKey
     * @return 平台
     */
    OrderPlatInfo selectOrderPlatInfoByAppKey(String appKey);
}
