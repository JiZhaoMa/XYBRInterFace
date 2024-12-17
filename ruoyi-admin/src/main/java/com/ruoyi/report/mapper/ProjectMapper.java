package com.ruoyi.report.mapper;

import com.ruoyi.report.domain.project.*;

import java.util.List;

public interface ProjectMapper {
    List<ProjectDefect> getProjectDefect(ProjectDefect projectDefect);
    List<QuestionCloseLoop> getQuestionCloseLoop(QuestionCloseLoop questionCloseLoop);
    List<Risk> getRisk(Risk risk);
    List<SourceInve> getSourceInve(SourceInve sourceInve);
    Cost getCost(Cost cost);
    Cost getCostRate(Cost cost);
    CostComp getCostComp(CostComp costComp);
    BudgetExpen getBudgetExpen(BudgetExpen budgetExpen);
    List<ProjectBudget> getProjectBudget(ProjectBudget projectBudget);
    List<EcLedger> getEcLedger(EcLedger ecLedger);
    List<ProjectChange> getProjectChange(ProjectChange projectChange);
    List<Project> getProject();
    List<ProjectPlan> getProjectPlan(ProjectPlan projectPlan);
    List<ProjectKeyQuestion> getProjectKeyQuestion(ProjectKeyQuestion projectKeyQuestion);
    List<ProjectProcess> getProjectProcess(ProjectProcess p);
}
