package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.ARBill;
import com.ruoyi.u9c.domain.Voucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoucherBpmMapper {
    public int insertVoucher(List<Voucher> list);
    public int deleteVoucher(@Param("month") String month);
    public int updateVoucher(@Param("month") String month, @Param("sumMoney") int sumMoney );
}
