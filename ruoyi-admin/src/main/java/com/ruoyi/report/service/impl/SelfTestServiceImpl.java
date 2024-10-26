package com.ruoyi.report.service.impl;

import com.ruoyi.report.domain.selfTest.PriorityQuestion;
import com.ruoyi.report.mapper.SelfTestMapper;
import com.ruoyi.report.service.SelfTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfTestServiceImpl implements SelfTestService {
    @Autowired
    SelfTestMapper selfTestMapper;
    @Override
    public List<PriorityQuestion> getPriorityQues(String project) {
        return selfTestMapper.getPriorityQues(project);
    }
}
