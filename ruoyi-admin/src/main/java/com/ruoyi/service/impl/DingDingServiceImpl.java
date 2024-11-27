package com.ruoyi.service.impl;

import com.aliyun.dingtalkattendance_1_0.models.GetLeaveRecordsResponseBody;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.domain.DingDingUser;
import com.ruoyi.mapper.DingDingMapper;
import com.ruoyi.service.DingDingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@DataSource(value = DataSourceType.SLAVE)
@Service
public class DingDingServiceImpl implements DingDingService {
    @Autowired
    DingDingMapper dingDingMapper;

    @Override
    public void updateJobNumber(List<DingDingUser> list) {
        dingDingMapper.updateJobNumber(list);
        dingDingMapper.updateDeptNumber(list);
    }

    @Override
    public List<DingDingUser> getUserList() {
        return dingDingMapper.getUserList();
    }

    @Override
    public DingDingUser getUserId(DingDingUser dingDingUser) {
        return dingDingMapper.getUserId(dingDingUser);
    }

    @Override
    public int insertLeaveRecords(List<GetLeaveRecordsResponseBody.GetLeaveRecordsResponseBodyResultLeaveRecords> list) {
        return dingDingMapper.insertLeaveRecords(list);
    }
}
