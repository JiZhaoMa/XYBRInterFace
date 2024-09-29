package com.ruoyi.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.domain.Department;
import com.ruoyi.domain.User;
import com.ruoyi.mapper.BPMMapper;
import com.ruoyi.mapper.U9CMapper;
import com.ruoyi.service.BPMService;
import com.ruoyi.service.U9CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@DataSource(value = DataSourceType.SLAVE)
@Service
public class BPMServiceImpl implements BPMService {
    @Autowired
    BPMMapper bpmMapper;

    @Override
    public List<Department> getDepartList(int level) {
        return bpmMapper.getDepartList(level);
    }

    @Override
    public int updateDeptU9CCode(Department department) {
        return bpmMapper.updateDeptU9CCode(department);
    }

    @Override
    public List<User> getUserList() {
        return bpmMapper.getUserList();
    }

}
