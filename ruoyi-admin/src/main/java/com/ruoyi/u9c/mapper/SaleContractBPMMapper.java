package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.SaleContract;

import java.util.List;

public interface SaleContractBPMMapper {
    int deletSaleContrace();
    int insertSaleContrace(List<SaleContract> list);
}
