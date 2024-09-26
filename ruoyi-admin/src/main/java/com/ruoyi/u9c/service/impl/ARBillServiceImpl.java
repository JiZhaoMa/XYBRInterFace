package com.ruoyi.u9c.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.u9c.domain.ARBill;
import com.ruoyi.u9c.mapper.ARBillMapper;
import com.ruoyi.u9c.service.ARBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@DataSource(value = DataSourceType.U9C)
@Service
public class ARBillServiceImpl implements ARBillService {
    @Autowired
    ARBillMapper arBillMapper;
    @Override
    public List<ARBill> getARBill(String year, String month) {
        return arBillMapper.getARBill(year,month);
    }
}
