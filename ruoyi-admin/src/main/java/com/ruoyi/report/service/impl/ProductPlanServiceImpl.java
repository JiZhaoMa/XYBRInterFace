package com.ruoyi.report.service.impl;

import com.ruoyi.report.domain.ProductPlanOfMonth;
import com.ruoyi.report.domain.XybrOrder;
import com.ruoyi.report.mapper.ProductPlanMapper;
import com.ruoyi.report.service.ProductPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPlanServiceImpl implements ProductPlanService {
    @Autowired
    private ProductPlanMapper productPlanMapper;

    @Override
    public List<ProductPlanOfMonth> selectproductPlanOfMonthList(ProductPlanOfMonth productPlanOfMonth) {
        return productPlanMapper.selectproductPlanOfMonthList(productPlanOfMonth);
    }
}
