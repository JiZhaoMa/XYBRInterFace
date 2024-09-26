package com.ruoyi.service;

import com.ruoyi.domain.DingDingUser;

import java.util.List;

public interface DingDingService {
    public void updateJobNumber(List<DingDingUser> list);
    public List<DingDingUser> getUserList();
    public DingDingUser getUserId(DingDingUser dingDingUser);
}
