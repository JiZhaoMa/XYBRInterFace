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

    List<JiangBneMuBiao> getJiangBneMuBiao(List<String> list);

    List<AnShiJiaoFu> getAnShiJiaoFu(List<String> list);

    List<MaoLi> getMaoLi(List<String> list);

    List<QIJianFeiYongRate> getQIJianFeiYongRate(CockpitData cockpitData);

    List<ChanPinZhiTongRate> getChanPinZhiTongRate(List<String> list);

    List<ShiChangGuZhangRate> getShiChangGuZhangRate(List<String> list);

    List<KaiXiangBuLiangRate> getKaiXiangBuLiangRate(List<String> list);

    List<ChanPinQiDongRate> getChanPinQiDongRate(String monthStr);
    List<ZhuanLi> getZhuanLiList(String monthStr);
}
