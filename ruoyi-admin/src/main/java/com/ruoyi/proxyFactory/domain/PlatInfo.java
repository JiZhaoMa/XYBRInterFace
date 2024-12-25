package com.ruoyi.proxyFactory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 plat_info
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
public class PlatInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 平台名称 */
    @Excel(name = "平台名称")
    private String platName;

    /** appKey（TianBao：Base64加密） */
    @Excel(name = "appKey", readConverterExp = "T=ianBao：Base64加密")
    private String appKey;

    /** appSecret（TianBao：先Base64加密，再MD5加密） */
    @Excel(name = "appSecret", readConverterExp = "T=ianBao：先Base64加密，再MD5加密")
    private String appSecret;

    /** token有效期(单位小时) */
    @Excel(name = "token有效期(单位小时)")
    private Long tokenTime;

    /** 接入状态：  1:待接入 2:已接入  3:已暂停 */
    @Excel(name = "接入状态：  1:待接入 2:已接入  3:已暂停")
    private Long status;

    public void setPlatName(String platName) 
    {
        this.platName = platName;
    }

    public String getPlatName() 
    {
        return platName;
    }
    public void setAppKey(String appKey) 
    {
        this.appKey = appKey;
    }

    public String getAppKey() 
    {
        return appKey;
    }
    public void setAppSecret(String appSecret) 
    {
        this.appSecret = appSecret;
    }

    public String getAppSecret() 
    {
        return appSecret;
    }
    public void setTokenTime(Long tokenTime) 
    {
        this.tokenTime = tokenTime;
    }

    public Long getTokenTime() 
    {
        return tokenTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("platName", getPlatName())
            .append("appKey", getAppKey())
            .append("appSecret", getAppSecret())
            .append("tokenTime", getTokenTime())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
