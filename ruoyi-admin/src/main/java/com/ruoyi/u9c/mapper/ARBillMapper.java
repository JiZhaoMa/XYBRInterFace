package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.ARBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ARBillMapper {
    public List<ARBill> getARBill(@Param("year") String year, @Param("month")String month);
}
