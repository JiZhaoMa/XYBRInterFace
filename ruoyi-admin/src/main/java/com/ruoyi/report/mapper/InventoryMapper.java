package com.ruoyi.report.mapper;

import com.ruoyi.report.domain.InventoryOfCurrent;
import com.ruoyi.report.domain.InventoryOfMonth;
import com.ruoyi.report.domain.InventoryStatus;
import com.ruoyi.report.domain.InventoryTurnoverData;

import java.util.List;

public interface InventoryMapper {
    public InventoryTurnoverData getInventoryTurnoverData(InventoryTurnoverData inventoryTurnoverData);
    public List<InventoryStatus> getInventoryStatusList(InventoryStatus inventoryStatus);
    public InventoryOfMonth getInventoryOfMonth(InventoryOfMonth inventoryOfMonth);
    public List<InventoryOfCurrent> getInventoryOfCurrent(InventoryOfCurrent inventoryOfCurrent);
}
