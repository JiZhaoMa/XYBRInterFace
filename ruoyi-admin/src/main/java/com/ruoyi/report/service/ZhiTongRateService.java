package com.ruoyi.report.service;

import com.ruoyi.report.domain.*;

import java.util.List;

public interface ZhiTongRateService {
    public List<CurrentZhiTongRate> getCurMonZhiTongRate(CurrentZhiTongRate currentZhiTongRate);//当月直通率
    public CurrentZhiTongRate getZongHeZhiTongRate(CurrentZhiTongRate currentZhiTongRate);//各阶段综合直通率
    public List<SeriesFirstZhiTongRate> getSeriesFirstZhiTongRate(SeriesFirstZhiTongRate seriesFirstZhiTongRate);//系列一次直通率
    public List<CurYearSumZhiTongRate> getCurYearSumZhiTongRate(CurYearSumZhiTongRate curYearSumZhiTongRate);//当年累计直通率
    public List<MonthOfZhiTongRate> getMonthOfZhiTongRate(MonthOfZhiTongRate monthOfZhiTongRate);//月滚动直通率
    public List<MonthOfZhiTongRate> getMonthOfStock(MonthOfZhiTongRate monthOfZhiTongRate);//月滚动库存
}
