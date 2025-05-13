package com.ruoyi.u9c.service;

import com.ruoyi.u9c.domain.ItemLotCodeInfo;

import java.util.List;

public interface ItemLotCodeU9CService {
    public List<ItemLotCodeInfo> getItemLotCodeList(String itemCode);
    public int updateLotCode(ItemLotCodeInfo itemLotCodeInfo);
}
