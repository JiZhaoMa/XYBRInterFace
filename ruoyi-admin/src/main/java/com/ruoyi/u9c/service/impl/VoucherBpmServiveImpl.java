package com.ruoyi.u9c.service.impl;

import com.ruoyi.u9c.domain.ARBill;
import com.ruoyi.u9c.domain.Voucher;
import com.ruoyi.u9c.mapper.ARBillBpmMapper;
import com.ruoyi.u9c.mapper.VoucherBpmMapper;
import com.ruoyi.u9c.service.ARBillBpmServive;
import com.ruoyi.u9c.service.VoucherBpmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherBpmServiveImpl implements VoucherBpmService {
    @Autowired
    VoucherBpmMapper voucherBpmMapper;

    @Override
    public int insertVoucher(List<Voucher> list) {
        return voucherBpmMapper.insertVoucher(list);
    }

    @Override
    public int deleteVoucher(String month) {
        return voucherBpmMapper.deleteVoucher(month);
    }

    @Override
    public int updateVoucher(String month, int sumMoney) {
        return voucherBpmMapper.updateVoucher(month,sumMoney);
    }
}
