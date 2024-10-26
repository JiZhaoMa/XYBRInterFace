package com.ruoyi.service;

import com.ruoyi.domain.Department;
import com.ruoyi.domain.FixedFiled;
import com.ruoyi.domain.Supplier;
import com.ruoyi.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BPMService {
    public List<Department> getDepartList(int level);
    public int updateDeptU9CCode(Department department);
    public int updateUserInfoDeptU9CCode(List<User> list);
    public List<User> getUserList();
    public int insertFixedFiled(List<FixedFiled> list);
    public int insertSupplier(List<Supplier> list);
}
