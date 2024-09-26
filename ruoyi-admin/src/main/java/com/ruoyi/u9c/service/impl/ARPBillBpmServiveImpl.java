package com.ruoyi.u9c.service.impl;

import com.ruoyi.u9c.domain.ARBill;
import com.ruoyi.u9c.mapper.ARBillBpmMapper;
import com.ruoyi.u9c.service.ARBillBpmServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ARPBillBpmServiveImpl implements ARBillBpmServive {
    @Autowired
    ARBillBpmMapper arBillBpmMapper;
    @Override
    public int insertARBill(List<ARBill> list) {
        return arBillBpmMapper.insertARBill(list);
    }

    @Override
    public int deleteARBill(String month) {
        return arBillBpmMapper.deleteARBill(month);
    }
    @Override
    public int updateARBill(String month) {
        return arBillBpmMapper.updateARBill(month);
    }
}
