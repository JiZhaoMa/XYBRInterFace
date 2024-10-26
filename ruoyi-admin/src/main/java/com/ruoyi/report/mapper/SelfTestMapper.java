package com.ruoyi.report.mapper;

import com.ruoyi.report.domain.selfTest.PriorityQuestion;

import java.util.List;

public interface SelfTestMapper {
    List<PriorityQuestion> getPriorityQues(String project);
}
