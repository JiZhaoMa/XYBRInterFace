package com.ruoyi.u9c.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.u9c.domain.Voucher;
import com.ruoyi.u9c.mapper.VoucherMapper;
import com.ruoyi.u9c.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@DataSource(value = DataSourceType.U9C)
@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    VoucherMapper voucherMapper;
    @Override
    public List<Voucher> getVoucher(String month) {
        return voucherMapper.getVoucher(month);
    }
}
