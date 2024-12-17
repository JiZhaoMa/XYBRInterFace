package com.ruoyi.api.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.ruoyi.api.domian.OrderPlatInfo;
import com.ruoyi.api.mapper.OrderPlatInfoMapper;
import com.ruoyi.api.service.IOrderPlatInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 平台Service业务层处理
 *
 * @author kyrie
 * @date 2024-03-15
 */
@Service
public class OrderPlatInfoServiceImpl implements IOrderPlatInfoService {

    /** 雪花算法实体 */
    @Resource private Snowflake snowflake;

    @Resource private OrderPlatInfoMapper orderPlatInfoMapper;

    @Override
    public OrderPlatInfo selectOrderPlatInfoById(Long id) {
        return orderPlatInfoMapper.selectOrderPlatInfoById(id);
    }

    @Override
    public List<OrderPlatInfo> selectOrderPlatInfoList(OrderPlatInfo orderPlatInfo) {
        return orderPlatInfoMapper.selectOrderPlatInfoList(orderPlatInfo);
    }

    @Override
    public int insertOrderPlatInfo(OrderPlatInfo orderPlatInfo) {
        orderPlatInfo.setId(snowflake.nextId());
//        if (orderPlatInfo.getCreateBy() == null && SecurityUtils.isLogined()) {
//            orderPlatInfo.setCreateBy(SecurityUtils.getUserId().toString());
//            orderPlatInfo.setCreateByName(SecurityUtils.getNickname());
//        }
//        if (orderPlatInfo.getCreateTime() == null) {
//            orderPlatInfo.setCreateTime(DateUtils.getNowDate());
//        }
        return orderPlatInfoMapper.insertOrderPlatInfo(orderPlatInfo);
    }

    @Override
    public int updateOrderPlatInfo(OrderPlatInfo orderPlatInfo) {
//        if (orderPlatInfo.getUpdateBy() == null && SecurityUtils.isLogined()) {
//            orderPlatInfo.setUpdateBy(SecurityUtils.getUserId().toString());
//        }
//        if (orderPlatInfo.getUpdateTime() == null) {
//            orderPlatInfo.setUpdateTime(DateUtils.getNowDate());
//        }
        return orderPlatInfoMapper.updateOrderPlatInfo(orderPlatInfo);
    }

    @Override
    public int deleteOrderPlatInfoByIds(Long[] ids) {
        return orderPlatInfoMapper.deleteOrderPlatInfoByIds(ids);
    }

    @Override
    public int deleteOrderPlatInfoById(Long id) {
        return orderPlatInfoMapper.deleteOrderPlatInfoById(id);
    }

    @Override
    public OrderPlatInfo selectOrderPlatInfoByAppKey(String appKey) {
        return orderPlatInfoMapper.selectOrderPlatInfoByAppKey(appKey);
    }
}
