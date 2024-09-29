package com.ruoyi.service;

import com.ruoyi.domain.Department;
import com.ruoyi.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface U9CService {
    public List<Department> getU9CDeptByName(String name);
    public Department getDepartCode(Department d);
    public User getU9CUserInfo(User user);
    public int updateU9CUserInfo(User user);
}
