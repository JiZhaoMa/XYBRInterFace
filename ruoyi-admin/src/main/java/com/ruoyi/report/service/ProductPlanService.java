package com.ruoyi.report.service;

import com.ruoyi.report.domain.*;

import java.util.List;
import java.util.Map;

public interface ProductPlanService {
    public List<ProductPlanOfMonth> selectproductPlanOfMonthList(ProductPlanOfMonth productPlanOfMonth);
    public MonthPlan monthOfPlan(MonthPlan monthPlan);
    public List<ShippingDataRate> shippingDataRate(ShippingDataRate shippingDataRate);
    public List<ShippingNumOfMonth> getShippingNumOfMonth(ShippingNumOfMonth shippingNumOfMonth);
    public List<ShippingNumOfMonth> getSeriseName(ShippingNumOfMonth shippingNumOfMonth);
}
