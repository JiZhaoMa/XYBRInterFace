package com.ruoyi.report.service.impl;

import com.ruoyi.report.domain.*;
import com.ruoyi.report.mapper.ProductPlanMapper;
import com.ruoyi.report.service.ProductPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductPlanServiceImpl implements ProductPlanService {
    @Autowired
    private ProductPlanMapper productPlanMapper;

    @Override
    public List<ProductPlanOfMonth> selectproductPlanOfMonthList(ProductPlanOfMonth productPlanOfMonth) {
        return productPlanMapper.selectproductPlanOfMonthList(productPlanOfMonth);
    }

    @Override
    public MonthPlan monthOfPlan(MonthPlan monthPlan) {
        return productPlanMapper.monthOfPlan(monthPlan);
    }

    @Override
    public List<ShippingDataRate> shippingDataRate(ShippingDataRate shippingDataRate) {
        return productPlanMapper.shippingDataRate(shippingDataRate);
    }

    @Override
    public List<ShippingNumOfMonth> getShippingNumOfMonth(ShippingNumOfMonth shippingNumOfMonth) {
        return productPlanMapper.getShippingNumOfMonth(shippingNumOfMonth);
    }

    @Override
    public List<ShippingNumOfMonth> getSeriseName(ShippingNumOfMonth shippingNumOfMonth) {
        return productPlanMapper.getSeriseName(shippingNumOfMonth);
    }
}
