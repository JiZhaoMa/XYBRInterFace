package com.ruoyi.proxyFactory.service;

import com.ruoyi.proxyFactory.domain.InterfaceInfo;

import java.util.List;
/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-01-21
 */
public interface IInterfaceInfoService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public InterfaceInfo selectInterfaceInfoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param interfaceInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<InterfaceInfo> selectInterfaceInfoList(InterfaceInfo interfaceInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param interfaceInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertInterfaceInfo(InterfaceInfo interfaceInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param interfaceInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateInterfaceInfo(InterfaceInfo interfaceInfo);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInterfaceInfoByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteInterfaceInfoById(Long id);
}
