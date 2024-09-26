package com.ruoyi.u9c.service;

import com.ruoyi.u9c.domain.Voucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoucherBpmService {
    public int insertVoucher(List<Voucher> list);
    public int deleteVoucher(String month);
    public int updateVoucher(String month, int sumMoney );
}
