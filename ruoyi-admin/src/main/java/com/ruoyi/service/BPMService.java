package com.ruoyi.service;

import com.ruoyi.domain.Department;
import com.ruoyi.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BPMService {
    public List<Department> getDepartList(int level);
    public int updateDeptU9CCode(Department department);
    public List<User> getUserList();
}
