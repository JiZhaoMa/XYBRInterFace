package com.ruoyi.report.service;

import com.ruoyi.report.domain.ProductPlanOfMonth;
import com.ruoyi.report.domain.XybrOrder;

import java.util.List;

public interface ProductPlanService {
    public List<ProductPlanOfMonth> selectproductPlanOfMonthList(ProductPlanOfMonth productPlanOfMonth);
}
