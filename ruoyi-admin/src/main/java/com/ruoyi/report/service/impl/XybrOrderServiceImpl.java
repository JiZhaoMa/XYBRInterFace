package com.ruoyi.report.service.impl;

import java.util.List;

import com.ruoyi.report.domain.AgentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.report.mapper.XybrOrderMapper;
import com.ruoyi.report.domain.XybrOrder;
import com.ruoyi.report.service.IXybrOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
@Service
public class XybrOrderServiceImpl implements IXybrOrderService 
{
    @Autowired
    private XybrOrderMapper XybrOrderMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param 产品编码 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public XybrOrder selectXybrOrderById(String 产品编码)
    {
        return XybrOrderMapper.selectXybrOrderById(产品编码);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param XybrOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<XybrOrder> selectXybrOrderList(XybrOrder XybrOrder)
    {
        return XybrOrderMapper.selectXybrOrderList(XybrOrder);
    }
    /**
     * 查询【请填写功能名称】
     *
     * @param 星源生产po 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public List<XybrOrder> selectAgentOrderList(XybrOrder XybrOrder)
    {
        return XybrOrderMapper.selectAgentOrderList(XybrOrder);
    }
}
