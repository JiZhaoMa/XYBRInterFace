package com.ruoyi.report.service;

import com.ruoyi.report.domain.selfTest.PriorityQuestion;

import java.util.List;

public interface SelfTestService {
    List<PriorityQuestion> getPriorityQues(String project);
}
