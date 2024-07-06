package com.ruoyi.report.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.report.domain.cockpit.*;
import com.ruoyi.report.mapper.CockpitMapper;
import com.ruoyi.report.service.CockpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DataSource(value = DataSourceType.SLAVE)
public class CockpitServiceImpl implements CockpitService {
    @Autowired
    private CockpitMapper cockpitMapper;
    @Override
    public CockpitData getCockpitData(String month) {
        return cockpitMapper.getCockpitData(month);
    }

    @Override
    public List<TenClient> getTenClient(String month) {
        return cockpitMapper.getTenClient(month);
    }


    @Override
    public List<Performance> getPerformance(String month) {
        return cockpitMapper.getPerformance(month);
    }

    @Override
    public List<YuQiClientData> getYuQiClientData(String monthStr) {
        return cockpitMapper.getYuQiClientData(monthStr);
    }

    @Override
    public StockData getStockData(String monthStr) {
        return cockpitMapper.getStockData(monthStr);
    }

    @Override
    public List<JiangBneMuBiao> getJiangBneMuBiao(List<String> monthList) {
        return cockpitMapper.getJiangBneMuBiao(monthList);
    }

    @Override
    public List<AnShiJiaoFu> getAnShiJiaoFu(List<String> monthList) {
        return cockpitMapper.getAnShiJiaoFu(monthList);
    }

    @Override
    public List<MaoLi> getMaoLi(List<String> monthList) {
        return cockpitMapper.getMaoLi(monthList);
    }

    @Override
    public List<QIJianFeiYongRate> getQIJianFeiYongRate(CockpitData cockpitData) {
        return cockpitMapper.getQIJianFeiYongRate(cockpitData);
    }

    @Override
    public List<ChanPinZhiTongRate> getChanPinZhiTongRate(List<String> monthList) {
        return cockpitMapper.getChanPinZhiTongRate(monthList);
    }

    @Override
    public List<ShiChangGuZhangRate> getShiChangGuZhangRate(List<String> monthList) {
        return cockpitMapper.getShiChangGuZhangRate(monthList);
    }

    @Override
    public List<KaiXiangBuLiangRate> getKaiXiangBuLiangRate(List<String> monthList) {
        return cockpitMapper.getKaiXiangBuLiangRate(monthList);
    }

    @Override
    public List<ChanPinQiDongRate> getChanPinQiDongRate(String monthStr) {
        return cockpitMapper.getChanPinQiDongRate(monthStr);
    }

    @Override
    public List<ProjectInfo> getProjectInfo(String monthStr) {
        return cockpitMapper.getProjectInfo(monthStr);
    }

    @Override
    public List<ZhuanLi> getZhuanLiList(String monthStr) {
        return cockpitMapper.getZhuanLiList(monthStr);
    }
}
