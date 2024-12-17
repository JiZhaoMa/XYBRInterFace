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
 * 接口信息对象 order_inter_info
 *
 * @author kyrie
 * @date 2024-03-15
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class OrderInterInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 无符号，雪花算法id */
    private Long id;

    /** 接口名称 */
    @Excel(name = "接口名称")
    private String name;

    /** 接口描述 */
    @Excel(name = "接口描述")
    private String intDesc;

    /** 请求路径 */
    @Excel(name = "请求路径")
    private String url;

    /** 接口方法 */
    @Excel(name = "接口方法")
    private String method;

    /** 开发者 */
    @Excel(name = "开发者")
    private String developer;

    /** 接口状态：1:开发中   2:运行中  3:暂停 */
    @Excel(name = "接口状态：1:开发中   2:运行中  3:暂停")
    private Integer intStatus;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createByName;

    /** 最终修改人 */
    @Excel(name = "最终修改人")
    private String updateByName;

    /** 请求方式(1:GET 2:POST 3:PUT 4:DELETE) */
    @Excel(name = "请求方式(1:GET 2:POST 3:PUT 4:DELETE)")
    private Integer methodType;

    private Long platId;

    /**
     * 待授权接口ID集合
     */
    private Long[] selectInterIds;

    private String typeName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntDesc() {
        return intDesc;
    }

    public void setIntDesc(String intDesc) {
        this.intDesc = intDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(Integer intStatus) {
        this.intStatus = intStatus;
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

    public Integer getMethodType() {
        return methodType;
    }

    public void setMethodType(Integer methodType) {
        this.methodType = methodType;
    }

    public Long getPlatId() {
        return platId;
    }

    public void setPlatId(Long platId) {
        this.platId = platId;
    }

    public Long[] getSelectInterIds() {
        return selectInterIds;
    }

    public void setSelectInterIds(Long[] selectInterIds) {
        this.selectInterIds = selectInterIds;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
                .append("name", getName())
                .append("intDesc", getIntDesc())
                .append("url", getUrl())
                .append("method", getMethod())
                .append("developer", getDeveloper())
                .append("intStatus", getIntStatus())
                .append("createBy", getCreateBy())
                .append("createByName", getCreateByName())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateByName", getUpdateByName())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("methodType", getMethodType())
                .append("platId", getPlatId())
                .append("selectInterIds", getSelectInterIds())
                .append("typeName", getTypeName())
                .toString();
    }
}
