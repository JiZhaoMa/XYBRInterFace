package com.ruoyi.u9c.service;

import com.ruoyi.u9c.domain.ARBill;
import com.ruoyi.u9c.domain.Voucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoucherService {
    public List<Voucher> getVoucher(@Param("month")String month);
}
