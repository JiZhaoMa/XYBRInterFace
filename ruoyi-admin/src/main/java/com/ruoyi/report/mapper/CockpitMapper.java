package com.ruoyi.report.mapper;

import com.ruoyi.report.domain.cockpit.*;

import java.util.List;


public interface CockpitMapper {
    public CockpitData getCockpitData(String month);
    public List<TenClient> getTenClient(String month);
    public List<Performance> getPerformance(String month);
    List<ProjectInfo> getProjectInfo(String monthStr);
    List<YuQiClientData> getYuQiClientData(String monthStr);

    StockData getStockData(String monthStr);

    List<JiangBneMuBiao> getJiangBneMuBiao(String monthStr);

    List<AnShiJiaoFu> getAnShiJiaoFu(String monthStr);

    List<MaoLi> getMaoLi(String monthStr);

    List<QIJianFeiYongRate> getQIJianFeiYongRate(CockpitData cockpitData);

    List<ChanPinZhiTongRate> getChanPinZhiTongRate(String monthStr);

    List<ShiChangGuZhangRate> getShiChangGuZhangRate(String monthStr);

    List<KaiXiangBuLiangRate> getKaiXiangBuLiangRate(String monthStr);

    List<ChanPinQiDongRate> getChanPinQiDongRate(String monthStr);
    List<ZhuanLi> getZhuanLiList(String monthStr);
}
