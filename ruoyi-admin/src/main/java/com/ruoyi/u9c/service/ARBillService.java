package com.ruoyi.u9c.service;

import com.ruoyi.u9c.domain.ARBill;

import java.util.List;

public interface ARBillService {
    public List<ARBill> getARBill(String year, String month);
}
