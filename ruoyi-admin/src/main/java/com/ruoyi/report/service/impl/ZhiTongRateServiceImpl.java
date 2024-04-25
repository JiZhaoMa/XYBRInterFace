package com.ruoyi.report.service.impl;

import com.ruoyi.report.domain.CurYearSumZhiTongRate;
import com.ruoyi.report.domain.CurrentZhiTongRate;
import com.ruoyi.report.domain.MonthOfZhiTongRate;
import com.ruoyi.report.domain.SeriesFirstZhiTongRate;
import com.ruoyi.report.mapper.ZhiTongRateMapper;
import com.ruoyi.report.service.ZhiTongRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ZhiTongRateServiceImpl implements ZhiTongRateService {
    @Autowired
    private ZhiTongRateMapper zhiTongRateMapper;
    @Override
    public List<CurrentZhiTongRate> getCurMonZhiTongRate(CurrentZhiTongRate currentZhiTongRate) {
        return zhiTongRateMapper.getCurMonZhiTongRate(currentZhiTongRate);
    }

    @Override
    public CurrentZhiTongRate getZongHeZhiTongRate(CurrentZhiTongRate currentZhiTongRate) {
        return zhiTongRateMapper.getZongHeZhiTongRate(currentZhiTongRate);
    }

    @Override
    public List<SeriesFirstZhiTongRate> getSeriesFirstZhiTongRate(SeriesFirstZhiTongRate seriesFirstZhiTongRate) {
        return zhiTongRateMapper.getSeriesFirstZhiTongRate(seriesFirstZhiTongRate);
    }

    @Override
    public List<CurYearSumZhiTongRate> getCurYearSumZhiTongRate(CurYearSumZhiTongRate curYearSumZhiTongRate) {
        return zhiTongRateMapper.getCurYearSumZhiTongRate(curYearSumZhiTongRate);
    }

    @Override
    public List<MonthOfZhiTongRate> getMonthOfZhiTongRate(MonthOfZhiTongRate monthOfZhiTongRate) {
        return zhiTongRateMapper.getMonthOfZhiTongRate(monthOfZhiTongRate);
    }

    @Override
    public List<MonthOfZhiTongRate> getMonthOfStock(MonthOfZhiTongRate monthOfZhiTongRate) {
        return zhiTongRateMapper.getMonthOfStock(monthOfZhiTongRate);
    }

}
