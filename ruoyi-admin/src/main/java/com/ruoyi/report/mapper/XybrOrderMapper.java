package com.ruoyi.report.mapper;

import java.util.List;
import com.ruoyi.report.domain.XybrOrder;
import com.ruoyi.report.domain.AgentOrder;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public interface XybrOrderMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param 产品编码 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public XybrOrder selectXybrOrderById(String xybrProductOrder);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param XybrOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<XybrOrder> selectXybrOrderList(XybrOrder XybrOrder);
    /**
     * 查询【请填写功能名称】
     *
     * @param 星源生产po 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public List<XybrOrder> selectAgentOrderList(XybrOrder XybrOrder);
}
