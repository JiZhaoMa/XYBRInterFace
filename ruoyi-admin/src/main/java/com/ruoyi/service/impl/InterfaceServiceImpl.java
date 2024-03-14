package com.ruoyi.service.impl;

import com.ruoyi.mapper.InterfaceMapper;
import com.ruoyi.domain.Order;
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
    public int insertOrderList(List<Order> list) {
        return interfaceMapper.insertOrderList(list);
    }
}
