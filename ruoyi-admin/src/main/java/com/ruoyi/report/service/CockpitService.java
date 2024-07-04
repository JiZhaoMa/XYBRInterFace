package com.ruoyi.report.service;

import com.ruoyi.report.domain.cockpit.*;

import java.util.List;

public interface CockpitService {
    public CockpitData getCockpitData(String month);
    public List<TenClient> getTenClient(String month);
    public List<Patent> getPatent(String month);
    public List<Performance> getPerformance(String month);

    List<YuQiClientData> getYuQiClientData(String monthStr);

    StockData getStockData(String monthStr);

    List<JiangBneMuBiao> getJiangBneMuBiao(List<String> monthList);

    List<AnShiJiaoFu> getAnShiJiaoFu(List<String> monthList);

    List<MaoLi> getMaoLi(List<String> monthList);

    List<QIJianFeiYongRate> getQIJianFeiYongRate(List<String> monthList);

    List<ChanPinZhiTongRate> getChanPinZhiTongRate(List<String> monthList);

    List<ShiChangGuZhangRate> getShiChangGuZhangRate(List<String> monthList);

    List<KaiXiangBuLiangRate> getKaiXiangBuLiangRate(List<String> monthList);

    List<ChanPinQiDongRate> getChanPinQiDongRate(String monthStr);

    List<ProjectInfo> getProjectInfo(String monthStr);
}
