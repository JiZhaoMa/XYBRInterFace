package com.ruoyi.report.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.report.domain.project.*;
import com.ruoyi.report.mapper.ProjectMapper;
import com.ruoyi.report.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

@DataSource(value = DataSourceType.SLAVE)
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Override
    public List<ProjectDefect> getProjectDefect(ProjectDefect projectDefect) {
        return projectMapper.getProjectDefect(projectDefect);
    }

    @Override
    public List<QuestionCloseLoop> getQuestionCloseLoop(QuestionCloseLoop questionCloseLoop) {
        return projectMapper.getQuestionCloseLoop(questionCloseLoop);
    }

    @Override
    public List<Risk> getRisk(Risk risk) {
        return projectMapper.getRisk(risk);
    }

    @Override
    public List<SourceInve> getSourceInve(SourceInve sourceInve) {
        return projectMapper.getSourceInve(sourceInve);
    }

    @Override
    public Cost getCost(Cost cost) {
        return projectMapper.getCost(cost);
    }

    @Override
    public Cost getCostRate(Cost cost) {
        return projectMapper.getCostRate(cost);
    }

    @Override
    public CostComp getCostComp(CostComp costComp) {
        return projectMapper.getCostComp(costComp);
    }

    @Override
    public BudgetExpen getBudgetExpen(BudgetExpen budgetExpen) {
        return projectMapper.getBudgetExpen(budgetExpen);
    }

    @Override
    public List<ProjectBudget> getProjectBudget(ProjectBudget projectBudget) {
        return projectMapper.getProjectBudget(projectBudget);
    }

    @Override
    public List<EcLedger> getEcLedger(EcLedger ecLedger) {
        return projectMapper.getEcLedger(ecLedger);
    }

    @Override
    public List<ProjectChange> getProjectChange(ProjectChange projectChange) {
        return projectMapper.getProjectChange(projectChange);
    }

    @Override
    public List<Project> getProject() {
        return projectMapper.getProject();
    }

    @Override
    public List<ProjectPlan> getProjectPlan(ProjectPlan projectPlan) {
        return projectMapper.getProjectPlan(projectPlan);
    }

    @Override
    public List<ProjectKeyQuestion> getProjectKeyQuestion(ProjectKeyQuestion projectKeyQuestion) {
        return projectMapper.getProjectKeyQuestion(projectKeyQuestion);
    }

    @Override
    public List<ProjectProcess> getProjectProcess(ProjectProcess p) {
        return projectMapper.getProjectProcess(p);
    }
}
