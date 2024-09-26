package com.ruoyi.u9c.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.u9c.domain.InvTrans;
import com.ruoyi.u9c.mapper.InvTransMapper;
import com.ruoyi.u9c.service.InvTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DataSource(value = DataSourceType.U9C)
@Service
public class InvTransServiceImpl implements InvTransService {
    @Autowired
    InvTransMapper invTransMapper;
    @Override
    public List<InvTrans> getInvTransList() {
        return invTransMapper.getInvTransList();
    }
}
