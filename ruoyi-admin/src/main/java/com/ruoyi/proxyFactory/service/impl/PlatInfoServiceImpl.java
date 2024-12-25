package com.ruoyi.proxyFactory.service.impl;

import java.util.Base64;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.proxyFactory.domain.PlatInfo;
import com.ruoyi.proxyFactory.mapper.PlatInfoMapper;
import com.ruoyi.proxyFactory.service.IPlatInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@Service
public class PlatInfoServiceImpl implements IPlatInfoService
{
    @Autowired
    private PlatInfoMapper platInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param platName 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public PlatInfo selectPlatInfoById(String platName)
    {
        return platInfoMapper.selectPlatInfoById(platName);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param platInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PlatInfo> selectPlatInfoList(PlatInfo platInfo)
    {
        return platInfoMapper.selectPlatInfoList(platInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param platInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPlatInfo(PlatInfo platInfo)
    {
        platInfo.setCreateTime(DateUtils.getNowDate());
        String app_key = Base64.getEncoder().encodeToString((platInfo.getPlatName()+"星源博锐").getBytes());
        String secret = Base64.getEncoder().encodeToString(app_key.getBytes());
        platInfo.setAppKey(app_key);
        platInfo.setAppSecret(secret);
        return platInfoMapper.insertPlatInfo(platInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param platInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePlatInfo(PlatInfo platInfo)
    {
        return platInfoMapper.updatePlatInfo(platInfo);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePlatInfoByIds(String ids)
    {
        return platInfoMapper.deletePlatInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param platName 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deletePlatInfoById(String platName)
    {
        return platInfoMapper.deletePlatInfoById(platName);
    }
}
