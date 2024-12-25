package com.ruoyi.proxyFactory.mapper;

import com.ruoyi.proxyFactory.domain.PlatInfo;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
public interface PlatInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param platName 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public PlatInfo selectPlatInfoById(String platName);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param platInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PlatInfo> selectPlatInfoList(PlatInfo platInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param platInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertPlatInfo(PlatInfo platInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param platInfo 【请填写功能名称】
     * @return 结果
     */
    public int updatePlatInfo(PlatInfo platInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param platName 【请填写功能名称】ID
     * @return 结果
     */
    public int deletePlatInfoById(String platName);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param platNames 需要删除的数据ID
     * @return 结果
     */
    public int deletePlatInfoByIds(String[] platNames);
}
