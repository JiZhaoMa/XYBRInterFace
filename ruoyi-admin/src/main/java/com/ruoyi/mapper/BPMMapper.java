package com.ruoyi.mapper;

import com.ruoyi.domain.Department;
import com.ruoyi.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BPMMapper {
    public List<Department> getDepartList(@Param("level") int level);
    public int updateDeptU9CCode(Department department);
    public List<User> getUserList();
}
