package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.SaleContract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleContractMapper {
    public List<SaleContract> getSaleContractList();
}
