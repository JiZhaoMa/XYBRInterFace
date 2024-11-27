package com.ruoyi.mapper;

import com.aliyun.dingtalkattendance_1_0.models.GetLeaveRecordsResponseBody;
import com.ruoyi.domain.DingDingUser;

import java.util.List;

public interface DingDingMapper {
    public void updateJobNumber(List<DingDingUser> list);
    public void updateDeptNumber(List<DingDingUser> list);
    public List<DingDingUser> getUserList();
    public DingDingUser getUserId(DingDingUser dingDingUser);
    public int insertLeaveRecords(List<GetLeaveRecordsResponseBody.GetLeaveRecordsResponseBodyResultLeaveRecords> list);
}
