package com.ruoyi.report.domain;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * 【请填写功能名称】对象 XybrOrder
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public class XybrOrder extends BaseEntity
{
    /** $column.columnComment */
    private String productCode;

    private String parentId;

    /** $column.columnComment */
    @Excel(name = "星源生产单号", readConverterExp = "$column.readConverterExp()")
    private String xybrProductOrder;

    /** $column.columnComment */
    @Excel(name = "下单数", readConverterExp = "$column.readConverterExp()")
    private String orderNum;

    @Excel(name = "${smt订单上线时间}", readConverterExp = "$column.readConverterExp()")
    private String smtOrderOnlineTime;

    /** $column.columnComment */
    @Excel(name = "${smt数量}", readConverterExp = "$column.readConverterExp()")
    private String smtNum;

    /** $column.columnComment */
    @Excel(name = "${插件数量}", readConverterExp = "$column.readConverterExp()")
    private String chaJianNum;

    /** $column.columnComment */
    @Excel(name = "${ft数量}", readConverterExp = "$column.readConverterExp()")
    private String ftNum;

    /** $column.columnComment */
    @Excel(name = "${单板终验}", readConverterExp = "$column.readConverterExp()")
    private String danBanZhongYanNum;

    /** $column.columnComment */
    @Excel(name = "${单板组装}", readConverterExp = "$column.readConverterExp()")
    private String danBanZuzhuangNum;

    /** $column.columnComment */
    @Excel(name = "整机组装", readConverterExp = "$column.readConverterExp()")
    private String zhengJiZuzhaungNum;

    /** $column.columnComment */
    @Excel(name = "老化前", readConverterExp = "$column.readConverterExp()")
    private String laoHuaBeforNum;

    /** $column.columnComment */
    @Excel(name = "老化", readConverterExp = "$column.readConverterExp()")
    private String laoHuaNum;

    /** $column.columnComment */
    @Excel(name = "老化后", readConverterExp = "$column.readConverterExp()")
    private String laoHuaAfterNum;

    /** $column.columnComment */
    @Excel(name = "入库", readConverterExp = "$column.readConverterExp()")
    private String inbound;

    /** $column.columnComment */
    @Excel(name = "创建时间", readConverterExp = "$column.readConverterExp()")
    private Date createTime;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getXybrProductOrder() {
        return xybrProductOrder;
    }

    public void setXybrProductOrder(String xybrProductOrder) {
        this.xybrProductOrder = xybrProductOrder;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
    public String getSmtOrderOnlineTime() {
        return smtOrderOnlineTime;
    }

    public void setSmtOrderOnlineTime(String smtOrderOnlineTime) {
        this.smtOrderOnlineTime = smtOrderOnlineTime;
    }

    public String getSmtNum() {
        return smtNum;
    }

    public void setSmtNum(String smtNum) {
        this.smtNum = smtNum;
    }

    public String getChaJianNum() {
        return chaJianNum;
    }

    public void setChaJianNum(String chaJianNum) {
        this.chaJianNum = chaJianNum;
    }

    public String getFtNum() {
        return ftNum;
    }

    public void setFtNum(String ftNum) {
        this.ftNum = ftNum;
    }

    public String getDanBanZhongYanNum() {
        return danBanZhongYanNum;
    }

    public void setDanBanZhongYanNum(String danBanZhongYanNum) {
        this.danBanZhongYanNum = danBanZhongYanNum;
    }

    public String getDanBanZuzhuangNum() {
        return danBanZuzhuangNum;
    }

    public void setDanBanZuzhuangNum(String danBanZuzhuangNum) {
        this.danBanZuzhuangNum = danBanZuzhuangNum;
    }

    public String getZhengJiZuzhaungNum() {
        return zhengJiZuzhaungNum;
    }

    public void setZhengJiZuzhaungNum(String zhengJiZuzhaungNum) {
        this.zhengJiZuzhaungNum = zhengJiZuzhaungNum;
    }

    public String getLaoHuaBeforNum() {
        return laoHuaBeforNum;
    }

    public void setLaoHuaBeforNum(String laoHuaBeforNum) {
        this.laoHuaBeforNum = laoHuaBeforNum;
    }

    public String getLaoHuaNum() {
        return laoHuaNum;
    }

    public void setLaoHuaNum(String laoHuaNum) {
        this.laoHuaNum = laoHuaNum;
    }

    public String getLaoHuaAfterNum() {
        return laoHuaAfterNum;
    }

    public void setLaoHuaAfterNum(String laoHuaAfterNum) {
        this.laoHuaAfterNum = laoHuaAfterNum;
    }

    public String getInbound() {
        return inbound;
    }

    public void setInbound(String inbound) {
        this.inbound = inbound;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /** $column.columnComment */
    @Excel(name = "工厂名称", readConverterExp = "$column.readConverterExp()")
    private String agentName;
}
