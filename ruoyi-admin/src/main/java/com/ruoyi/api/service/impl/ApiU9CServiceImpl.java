package com.ruoyi.api.service.impl;

import com.ruoyi.api.domian.Material;
import com.ruoyi.api.mapper.ApiU9CMapper;
import com.ruoyi.api.service.ApiU9CService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@DataSource(value = DataSourceType.U9C)
@Service
public class ApiU9CServiceImpl implements ApiU9CService {
    @Autowired
    ApiU9CMapper apiU9CMapper;
    @Override
    public List<Material> getMaterial(Material material) {
        return apiU9CMapper.getMaterial(material);
    }
}
