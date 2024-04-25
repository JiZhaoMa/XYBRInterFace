package com.ruoyi.report.mapper;

import com.ruoyi.report.domain.*;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-19
 */
public interface ZhiTongRateMapper
{
    public List<CurrentZhiTongRate> getCurMonZhiTongRate(CurrentZhiTongRate currentZhiTongRate);//当月直通率
    public CurrentZhiTongRate getZongHeZhiTongRate(CurrentZhiTongRate currentZhiTongRate);//各阶段综合直通率
    public List<SeriesFirstZhiTongRate> getSeriesFirstZhiTongRate(SeriesFirstZhiTongRate seriesFirstZhiTongRate);//系列一次直通率
    public List<CurYearSumZhiTongRate> getCurYearSumZhiTongRate(CurYearSumZhiTongRate curYearSumZhiTongRate);//当年累计直通率
    public List<MonthOfZhiTongRate> getMonthOfZhiTongRate(MonthOfZhiTongRate monthOfZhiTongRate);//月滚动直通率
    public List<MonthOfZhiTongRate> getMonthOfStock(MonthOfZhiTongRate monthOfZhiTongRate);//月滚动库存
}
