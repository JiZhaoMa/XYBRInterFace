package com.ruoyi.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 【请填写功能名称】对象 AgentOrder
 * 
 * @author ruoyi
 * @date 2024-03-20
 */
public class AgentOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 星源生产po;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 工厂生产po;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 工单数量;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String smt订单上线时间;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String smt数量;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 插件数量;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ft数量;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 单板终验数量;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 单板组装数量;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date 创建时间;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String 工厂名称;

    public void set星源生产po(String 星源生产po) 
    {
        this.星源生产po = 星源生产po;
    }

    public String get星源生产po() 
    {
        return 星源生产po;
    }
    public void set工厂生产po(String 工厂生产po) 
    {
        this.工厂生产po = 工厂生产po;
    }

    public String get工厂生产po() 
    {
        return 工厂生产po;
    }
    public void set工单数量(String 工单数量) 
    {
        this.工单数量 = 工单数量;
    }

    public String get工单数量() 
    {
        return 工单数量;
    }
    public void setSmt订单上线时间(String smt订单上线时间) 
    {
        this.smt订单上线时间 = smt订单上线时间;
    }

    public String getSmt订单上线时间() 
    {
        return smt订单上线时间;
    }
    public void setSmt数量(String smt数量) 
    {
        this.smt数量 = smt数量;
    }

    public String getSmt数量() 
    {
        return smt数量;
    }
    public void set插件数量(String 插件数量) 
    {
        this.插件数量 = 插件数量;
    }

    public String get插件数量() 
    {
        return 插件数量;
    }
    public void setFt数量(String ft数量) 
    {
        this.ft数量 = ft数量;
    }

    public String getFt数量() 
    {
        return ft数量;
    }
    public void set单板终验数量(String 单板终验数量) 
    {
        this.单板终验数量 = 单板终验数量;
    }

    public String get单板终验数量() 
    {
        return 单板终验数量;
    }
    public void set单板组装数量(String 单板组装数量) 
    {
        this.单板组装数量 = 单板组装数量;
    }

    public String get单板组装数量() 
    {
        return 单板组装数量;
    }
    public void set创建时间(Date 创建时间) 
    {
        this.创建时间 = 创建时间;
    }

    public Date get创建时间() 
    {
        return 创建时间;
    }
    public void set工厂名称(String 工厂名称) 
    {
        this.工厂名称 = 工厂名称;
    }

    public String get工厂名称() 
    {
        return 工厂名称;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("星源生产po", get星源生产po())
            .append("工厂生产po", get工厂生产po())
            .append("工单数量", get工单数量())
            .append("smt订单上线时间", getSmt订单上线时间())
            .append("smt数量", getSmt数量())
            .append("插件数量", get插件数量())
            .append("ft数量", getFt数量())
            .append("单板终验数量", get单板终验数量())
            .append("单板组装数量", get单板组装数量())
            .append("创建时间", get创建时间())
            .append("工厂名称", get工厂名称())
            .toString();
    }
}
