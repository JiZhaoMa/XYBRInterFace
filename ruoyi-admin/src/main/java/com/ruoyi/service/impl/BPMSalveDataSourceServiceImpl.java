package com.ruoyi.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.mapper.BPMMapper;
import com.ruoyi.service.BPMSalveDataSourceService;
import com.ruoyi.u9c.domain.POLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DataSource(value = DataSourceType.SLAVE)
@Service
public class BPMSalveDataSourceServiceImpl implements BPMSalveDataSourceService {
    @Autowired
    BPMMapper bpmMapper;
    @Override
    public int updateCaiGouDetail(List<POLine> pOLineList, List<String> codeList, String orderCode, String supplier) {
        return bpmMapper.updateCaiGouDetail(pOLineList,codeList,orderCode,supplier);
    }
}
