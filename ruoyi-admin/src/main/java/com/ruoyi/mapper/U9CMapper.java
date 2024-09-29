package com.ruoyi.mapper;

import com.ruoyi.domain.Department;
import com.ruoyi.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface U9CMapper {
    public List<Department> getU9CDeptByName(@Param("name") String name);
    public Department getDepartCode(Department d);
    public User getU9CUserInfo(User user);
    public int updateU9CUserInfo(User user);
}
