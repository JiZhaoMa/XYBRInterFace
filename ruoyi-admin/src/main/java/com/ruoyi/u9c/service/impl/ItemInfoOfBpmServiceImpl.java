package com.ruoyi.u9c.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.u9c.domain.ItemInfo;
import com.ruoyi.u9c.mapper.ItemInfoOfBpmMapper;
import com.ruoyi.u9c.service.ItemInfoOfBpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@DataSource(value = DataSourceType.MASTER)
@Service
public class ItemInfoOfBpmServiceImpl implements ItemInfoOfBpmService {
    @Autowired
    ItemInfoOfBpmMapper itemInfoOfBpmMapper;
    @Override
    public ItemInfo getItemList(ItemInfo itemInfo) {
        return itemInfoOfBpmMapper.getItemList(itemInfo);
    }
}
