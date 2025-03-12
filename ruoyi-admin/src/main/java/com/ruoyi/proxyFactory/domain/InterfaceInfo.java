package com.ruoyi.proxyFactory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 interface_info
 * 
 * @author ruoyi
 * @date 2025-01-21
 */
public class InterfaceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String interfaceName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String interfaceIp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String interfaceUrl;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String authorization;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String grantType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String scope;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String username;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String password;

    /** 0失效1生效 */
    @Excel(name = "0失效1生效")
    private Integer status;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInterfaceName(String interfaceName) 
    {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceName() 
    {
        return interfaceName;
    }
    public void setInterfaceIp(String interfaceIp) 
    {
        this.interfaceIp = interfaceIp;
    }

    public String getInterfaceIp() 
    {
        return interfaceIp;
    }
    public void setInterfaceUrl(String interfaceUrl) 
    {
        this.interfaceUrl = interfaceUrl;
    }

    public String getInterfaceUrl() 
    {
        return interfaceUrl;
    }
    public void setAuthorization(String authorization) 
    {
        this.authorization = authorization;
    }

    public String getAuthorization() 
    {
        return authorization;
    }
    public void setGrantType(String grantType) 
    {
        this.grantType = grantType;
    }

    public String getGrantType() 
    {
        return grantType;
    }
    public void setScope(String scope) 
    {
        this.scope = scope;
    }

    public String getScope() 
    {
        return scope;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("interfaceName", getInterfaceName())
            .append("interfaceIp", getInterfaceIp())
            .append("interfaceUrl", getInterfaceUrl())
            .append("authorization", getAuthorization())
            .append("grantType", getGrantType())
            .append("scope", getScope())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("memo", getMemo())
            .toString();
    }
}
