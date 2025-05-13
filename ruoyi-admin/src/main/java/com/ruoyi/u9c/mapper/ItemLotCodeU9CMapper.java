package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.ItemLotCodeInfo;

import java.util.List;

public interface ItemLotCodeU9CMapper {
    public List<ItemLotCodeInfo> getItemLotCodeList(String itemCode);
    public int updateLotCode(ItemLotCodeInfo itemLotCodeInfo);
}
