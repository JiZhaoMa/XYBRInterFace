package com.ruoyi.report.service;

import com.ruoyi.report.domain.project.*;

import java.util.List;

public interface ProjectService {
    List<ProjectDefect> getProjectDefect(ProjectDefect projectDefect);
    List<QuestionCloseLoop> getQuestionCloseLoop(QuestionCloseLoop questionCloseLoop);
    List<Risk> getRisk(Risk risk);
    List<SourceInve> getSourceInve(SourceInve sourceInve);
    Cost getCost(Cost cost);
    CostComp getCostComp(CostComp costComp);
    BudgetExpen getBudgetExpen(BudgetExpen budgetExpen);
    List<ProjectBudget> getProjectBudget(ProjectBudget projectBudget);
    List<EcLedger> getEcLedger(EcLedger ecLedger);
    List<Project> getProject();
}
