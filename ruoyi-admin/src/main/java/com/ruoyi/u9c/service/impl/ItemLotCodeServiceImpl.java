package com.ruoyi.u9c.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.u9c.domain.ItemLotCodeInfo;
import com.ruoyi.u9c.mapper.ItemLotCodeMapper;
import com.ruoyi.u9c.service.ItemLotCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@DataSource(value = DataSourceType.MASTER)
@Service
public class ItemLotCodeServiceImpl implements ItemLotCodeService {
    @Autowired
    ItemLotCodeMapper itemLotCodeMapper;
    @Override
    public List<ItemLotCodeInfo> getItemLotCodeList(String itemCode) {
        return itemLotCodeMapper.getItemLotCodeList(itemCode);
    }
}
