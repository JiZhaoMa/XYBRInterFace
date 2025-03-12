package com.ruoyi.proxyFactory.service.impl;


import com.ruoyi.proxyFactory.domain.InterfaceInfo;
import com.ruoyi.proxyFactory.mapper.InterfaceInfoMapper;
import com.ruoyi.proxyFactory.service.IInterfaceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-21
 */
@Service
public class InterfaceInfoServiceImpl implements IInterfaceInfoService
{
    @Autowired
    private InterfaceInfoMapper interfaceInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public InterfaceInfo selectInterfaceInfoById(Long id)
    {
        return interfaceInfoMapper.selectInterfaceInfoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param interfaceInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<InterfaceInfo> selectInterfaceInfoList(InterfaceInfo interfaceInfo)
    {
        return interfaceInfoMapper.selectInterfaceInfoList(interfaceInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param interfaceInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertInterfaceInfo(InterfaceInfo interfaceInfo)
    {
        return interfaceInfoMapper.insertInterfaceInfo(interfaceInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param interfaceInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateInterfaceInfo(InterfaceInfo interfaceInfo)
    {
        return interfaceInfoMapper.updateInterfaceInfo(interfaceInfo);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInterfaceInfoByIds(String ids)
    {
        return interfaceInfoMapper.deleteInterfaceInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteInterfaceInfoById(Long id)
    {
        return interfaceInfoMapper.deleteInterfaceInfoById(id);
    }
}
