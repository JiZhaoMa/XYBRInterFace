package com.ruoyi.u9c.service;

import com.ruoyi.u9c.domain.ARBill;
import com.ruoyi.u9c.domain.InvTrans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ARBillBpmServive {
    public int insertARBill(List<ARBill> list);
    public int deleteARBill(String month);
    public int updateARBill(@Param("month") String month);
}
