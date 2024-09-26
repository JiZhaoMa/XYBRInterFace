package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.ARBill;
import com.ruoyi.u9c.domain.Voucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoucherMapper {
    public List<Voucher> getVoucher(@Param("month")String month);
}
