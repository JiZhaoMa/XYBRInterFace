package com.ruoyi.u9c.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.u9c.domain.SaleContract;
import com.ruoyi.u9c.mapper.SaleContractMapper;
import com.ruoyi.u9c.service.SaleContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@DataSource(value = DataSourceType.U9C)
@Service
public class SaleContractServiceImpl implements SaleContractService {
    @Autowired
    SaleContractMapper saleContractMapper;
    @Override
    public List<SaleContract> getSaleContractList() {
        return saleContractMapper.getSaleContractList();
    }
}
