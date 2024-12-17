package com.ruoyi.report.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.report.domain.patent.Patents;
import com.ruoyi.report.mapper.PatentMapper;
import com.ruoyi.report.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

@DataSource(value = DataSourceType.SLAVE)
public class PatentServiceImpl implements PatentService {
    @Autowired
    PatentMapper patentMapper;

    @Override
    public List<Patents> getPatentDetail(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth) {
        return patentMapper.getPatentDetail(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
    }

    @Override
    public List<Patents> getPatentAppType(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth) {
        return patentMapper.getPatentAppType(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
    }

    @Override
    public List<Patents> getPatentByType(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth) {
        return patentMapper.getPatentByType(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
    }

    @Override
    public List<Patents> getPatentByDept(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth) {
        return patentMapper.getPatentByDept(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
    }

    @Override
    public List<Patents> getPatentByPerson(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth) {
        return patentMapper.getPatentByPerson(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
    }

    @Override
    public List<Patents> getPatentByProxy(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth) {
        return patentMapper.getPatentByProxy(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
    }

    @Override
    public List<Patents> getPatentByYear(String dept,String person) {
        return patentMapper.getPatentByYear(dept,person);
    }
}
