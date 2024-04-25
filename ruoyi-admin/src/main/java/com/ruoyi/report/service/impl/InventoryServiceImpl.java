package com.ruoyi.report.service.impl;

import com.ruoyi.report.domain.InventoryOfCurrent;
import com.ruoyi.report.domain.InventoryOfMonth;
import com.ruoyi.report.domain.InventoryStatus;
import com.ruoyi.report.domain.InventoryTurnoverData;
import com.ruoyi.report.mapper.InventoryMapper;
import com.ruoyi.report.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;
    @Override
    public InventoryTurnoverData getInventoryTurnoverData(InventoryTurnoverData inventoryTurnoverData) {
        return inventoryMapper.getInventoryTurnoverData(inventoryTurnoverData);
    }

    @Override
    public List<InventoryStatus> getInventoryStatusList(InventoryStatus inventoryStatus) {
        return inventoryMapper.getInventoryStatusList(inventoryStatus);
    }

    @Override
    public InventoryOfMonth getInventoryOfMonth(InventoryOfMonth inventoryOfMonth) {
        return inventoryMapper.getInventoryOfMonth(inventoryOfMonth);
    }

    @Override
    public List<InventoryOfCurrent> getInventoryOfCurrent(InventoryOfCurrent inventoryOfCurrent) {
        return inventoryMapper.getInventoryOfCurrent(inventoryOfCurrent);
    }
}
