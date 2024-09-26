package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.ARBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ARBillBpmMapper {
    public int insertARBill(List<ARBill> list);
    public int deleteARBill(@Param("month") String month);
    public int updateARBill(@Param("month") String month);
}
