package com.ruoyi.service;

import com.ruoyi.domain.Department;
import com.ruoyi.domain.FixedFiled;
import com.ruoyi.domain.Supplier;
import com.ruoyi.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface U9CService {
    public List<Department> getU9CDeptByName(String name);
    public Department getDepartCode(Department d);
    public List<User> getU9CUserInfo(User user);
    public int updateU9CUserInfo(User user);
    public List<FixedFiled> getU9CFixedFiled();
    public List<Supplier> getU9CSupplier();
    public String getAssetCode(@Param("assetCard") String assetCard);
}
