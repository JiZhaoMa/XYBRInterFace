package com.ruoyi.u9c.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.u9c.domain.ItemLotCodeInfo;
import com.ruoyi.u9c.mapper.ItemLotCodeU9CMapper;
import com.ruoyi.u9c.service.ItemLotCodeU9CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DataSource(value = DataSourceType.U9C)
@Service
public class ItemLotCodeU9CServiceImpl implements ItemLotCodeU9CService {
    @Autowired
    ItemLotCodeU9CMapper itemLotCodeU9CMapper;
    @Override
    public List<ItemLotCodeInfo> getItemLotCodeList(String itemCode) {
        return itemLotCodeU9CMapper.getItemLotCodeList(itemCode);
    }

    @Override
    public int updateLotCode(ItemLotCodeInfo itemLotCodeInfo) {
        return itemLotCodeU9CMapper.updateLotCode(itemLotCodeInfo);
    }
}
