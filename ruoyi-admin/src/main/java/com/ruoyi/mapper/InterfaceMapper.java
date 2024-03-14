package com.ruoyi.mapper;

import com.ruoyi.domain.Order;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @description:
 * @Author: majizhao
 * @date: 2024/3/13 11:28
 */
@Mapper
public interface InterfaceMapper {
    public int insertOrderList(List<Order> list);
}
