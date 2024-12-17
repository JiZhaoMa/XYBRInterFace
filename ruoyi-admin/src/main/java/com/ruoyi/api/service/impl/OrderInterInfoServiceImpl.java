package com.ruoyi.api.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.ruoyi.api.domian.OrderInterInfo;
import com.ruoyi.api.domian.OrderPlatInfo;
import com.ruoyi.api.mapper.OrderInterInfoMapper;
import com.ruoyi.api.service.IOrderInterInfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

import java.util.List;

/**
 * 接口信息Service业务层处理
 *
 * @author kyrie
 * @date 2024-03-15
 */
@Service
public class OrderInterInfoServiceImpl implements IOrderInterInfoService {

    /** 雪花算法实体 */
    @Resource private Snowflake snowflake;

    @Resource private OrderInterInfoMapper orderInterInfoMapper;

    @Override
    public OrderInterInfo selectOrderInterInfoById(Long id) {
        return orderInterInfoMapper.selectOrderInterInfoById(id);
    }

    @Override
    public List<OrderInterInfo> selectOrderInterInfoList(OrderInterInfo orderInterInfo) {
        return orderInterInfoMapper.selectOrderInterInfoList(orderInterInfo);
    }

    @Override
    public int insertOrderInterInfo(OrderInterInfo orderInterInfo) {
//        orderInterInfo.setId(snowflake.nextId());
//        if (orderInterInfo.getCreateBy() == null && SecurityUtils.isLogined()) {
//            orderInterInfo.setCreateBy(SecurityUtils.getUserId().toString());
//            orderInterInfo.setCreateByName(SecurityUtils.getNickname());
//        }
//        if (orderInterInfo.getCreateTime() == null) {
//            orderInterInfo.setCreateTime(DateUtils.getNowDate());
//        }
        return orderInterInfoMapper.insertOrderInterInfo(orderInterInfo);
    }

    @Override
    public int updateOrderInterInfo(OrderInterInfo orderInterInfo) {
//        if (orderInterInfo.getUpdateBy() == null && SecurityUtils.isLogined()) {
//            orderInterInfo.setUpdateBy(SecurityUtils.getUserId().toString());
//        }
//        if (orderInterInfo.getUpdateTime() == null) {
//            orderInterInfo.setUpdateTime(DateUtils.getNowDate());
//        }
        return orderInterInfoMapper.updateOrderInterInfo(orderInterInfo);
    }

    @Override
    public int deleteOrderInterInfoByIds(Long[] ids) {
        return orderInterInfoMapper.deleteOrderInterInfoByIds(ids);
    }

    @Override
    public int deleteOrderInterInfoById(Long id) {
        return orderInterInfoMapper.deleteOrderInterInfoById(id);
    }

    @Override
    public List<OrderInterInfo> getAuthInterface(OrderInterInfo orderInterInfo) {
        return orderInterInfoMapper.getAuthInterface(orderInterInfo);
    }

    @Override
    public List<OrderInterInfo> getNoAuthInterList(Long platId) {
        return orderInterInfoMapper.getNoAuthInterList(platId);
    }

    @Override
    public int batchPlatInter(List<OrderPlatInfo> orderPlatInters) {
        return orderInterInfoMapper.batchPlatInter(orderPlatInters);
    }

    @Override
    public int cancelInterAuth(OrderInterInfo orderInterInfo) {
        return orderInterInfoMapper.cancelInterAuth(orderInterInfo);
    }
}
