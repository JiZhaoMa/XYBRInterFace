package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.ItemLotCodeInfo;

import java.util.List;

public interface ItemLotCodeMapper {
    public List<ItemLotCodeInfo> getItemLotCodeList(String itemCode);
}
