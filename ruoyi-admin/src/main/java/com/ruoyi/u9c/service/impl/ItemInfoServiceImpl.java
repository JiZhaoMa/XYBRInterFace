package com.ruoyi.u9c.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.u9c.domain.ItemInfo;
import com.ruoyi.u9c.mapper.ItemInfoMapper;
import com.ruoyi.u9c.service.ItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DataSource(value = DataSourceType.U9C)
@Service
public class ItemInfoServiceImpl implements ItemInfoService {
    @Autowired
    ItemInfoMapper itemInfoMapper;
    @Override
    public List<ItemInfo> getItemInfoList() {
        return itemInfoMapper.getItemInfoList();
    }
}
