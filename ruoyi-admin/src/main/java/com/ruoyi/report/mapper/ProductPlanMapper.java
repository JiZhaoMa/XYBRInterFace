package com.ruoyi.report.mapper;

import com.ruoyi.report.domain.*;

import java.util.List;
import java.util.Map;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public interface ProductPlanMapper
{
    /**
     * 查询【请填写功能名称】列表
     * 
     * @param XybrOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ProductPlanOfMonth> selectproductPlanOfMonthList(ProductPlanOfMonth productPlanOfMonth);
    public MonthPlan monthOfPlan(MonthPlan monthPlan);
    public List<ShippingDataRate> shippingDataRate(ShippingDataRate shippingDataRate);
    public List<ShippingNumOfMonth> getShippingNumOfMonth(ShippingNumOfMonth shippingNumOfMonth);
    public List<ShippingNumOfMonth> getSeriseName(ShippingNumOfMonth shippingNumOfMonth);
}
