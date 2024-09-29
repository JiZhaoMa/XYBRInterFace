package com.ruoyi.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.domain.Department;
import com.ruoyi.domain.User;
import com.ruoyi.mapper.U9CMapper;
import com.ruoyi.service.U9CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DataSource(value = DataSourceType.U9C)
@Service
public class U9CServiceImpl implements U9CService {
    @Autowired
    U9CMapper u9CMapper;

    @Override
    public List<Department> getU9CDeptByName(String name) {
        return u9CMapper.getU9CDeptByName(name);
    }
    @Override
    public Department getDepartCode(Department d) {
        return u9CMapper.getDepartCode(d);
    }

    @Override
    public User getU9CUserInfo(User user) {
        return u9CMapper.getU9CUserInfo(user);
    }

    @Override
    public int updateU9CUserInfo(User user) {
        return u9CMapper.updateU9CUserInfo(user);
    }
}
