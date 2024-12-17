package com.ruoyi.api.domian;


import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 平台对象 order_plat_info
 *
 * @author kyrie
 * @date 2024-03-15
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class OrderPlatInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 无符号，雪花算法id */
    private Long id;

    /** 平台名称 */
    @Excel
    private String platName;

    /** appKey */
    private String appKey;

    /** appSecret */
    private String appSecret;

    /** token有效期(单位小时) */
    @Excel(name = "token有效期(单位小时)")
    private Integer tokenTime;

    /** 接入状态：  1:待接入 2:已接入  3:已暂停 */
    @Excel(name = "接入状态：  1:待接入 2:已接入  3:已暂停")
    private Integer status;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createByName;

    /** 最终修改人 */
    @Excel(name = "最终修改人")
    private String updateByName;

    /**
     * 引用字段，无实际意义
     */
    private Integer pageNum;

    private Integer pageSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public Integer getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Integer tokenTime) {
        this.tokenTime = tokenTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("platName", getPlatName())
                .append("appKey", getAppKey())
                .append("appSecret", getAppSecret())
                .append("tokenTime", getTokenTime())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createByName", getCreateByName())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateByName", getUpdateByName())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
