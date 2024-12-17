package com.ruoyi.report.web;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.report.domain.cockpit.JiangBneMuBiao;
import com.ruoyi.report.domain.patent.Patents;
import com.ruoyi.report.domain.project.*;
import com.ruoyi.report.domain.selfTest.PriorityQuestion;
import com.ruoyi.report.service.ProjectService;
import com.ruoyi.report.service.SelfTestService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/report/project")
public class ProjectController extends BaseController {
    private String prefix = "report/project";

    @Autowired
    private ProjectService projectService;
    @GetMapping("/getProjectSingle")
    public String getProjectSingle()
    {
        return prefix + "/projectSingle";
    }
    @GetMapping("/getEcLedger")
    @ResponseBody
    public JSONObject getEcLedger(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        EcLedger ecLedger = new EcLedger();
        ProjectChange pc = new ProjectChange();
        ecLedger.setProjectCode(projectCode);
        pc.setProjectCode(projectCode);
        List<EcLedger> list = projectService.getEcLedger(ecLedger);
        List<ProjectChange> pclist = projectService.getProjectChange(pc);
        jsonObject.put("ecList",list);
        jsonObject.put("pclist",pclist);
        return jsonObject;
    }
    @GetMapping("/getRisk")
    @ResponseBody
    public JSONObject getRisk(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        Risk risk = new Risk();
        risk.setProjectCode(projectCode);
        List<Risk> list = projectService.getRisk(risk);
        List<String> riskTypeList = list.stream().map(Risk::getRiskType).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<Integer> maxNumList = list.stream().map(Risk::getRiskMaxNum).collect(Collectors.toList());
        List<Integer> numList = list.stream().map(Risk::getRiskNum).collect(Collectors.toList());
        jsonObject.put("riskTypeList",riskTypeList);
        jsonObject.put("maxNumList",maxNumList);
        jsonObject.put("numList",numList);
        return jsonObject;
    }
    @GetMapping("/getCost")
    @ResponseBody
    public JSONObject getCost(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        List<String> costTypeList = new ArrayList<>();
        List<Integer> costList = new ArrayList<>();
        Cost cost = new Cost();
        cost.setProjectCode(projectCode);
        cost = projectService.getCost(cost);
        if(!ObjectUtil.isEmpty(cost)){
            if(!ObjectUtil.isEmpty(cost.getCostValue01())){
                costTypeList.add("结构件");
                costList.add(cost.getCostValue01());
            }
            if(!ObjectUtil.isEmpty(cost.getCostValue02())){
                costTypeList.add("包材");
                costList.add(cost.getCostValue02());
            }
            if(!ObjectUtil.isEmpty(cost.getCostValue03())){
                costTypeList.add("定制件");
                costList.add(cost.getCostValue03());
            }
            if(!ObjectUtil.isEmpty(cost.getCostValue04())){
                costTypeList.add("标准电子件");
                costList.add(cost.getCostValue04());
            }
            if(!ObjectUtil.isEmpty(cost.getCostValue05())){
                costTypeList.add("PCB");
                costList.add(cost.getCostValue05());
            }
            if(!ObjectUtil.isEmpty(cost.getCostValue06())){
                costTypeList.add("工艺");
                costList.add(cost.getCostValue06());
            }
            if(!ObjectUtil.isEmpty(cost.getCostValue07())){
                costTypeList.add("加工成本");
                costList.add(cost.getCostValue07());
            }
            if(!ObjectUtil.isEmpty(cost.getCostValue08())){
                costTypeList.add("其他");
                costList.add(cost.getCostValue08());
            }
        }
        jsonObject.put("costList",costList);
        jsonObject.put("costTypeList",costTypeList);
        return jsonObject;
    }
    @GetMapping("/getProjectBudget")
    @ResponseBody
    public JSONObject getProjectBudget(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        ProjectBudget pb = new ProjectBudget();
        pb.setType("预算");
        pb.setProjectCode(projectCode);
        List<ProjectBudget> yusuanlist = projectService.getProjectBudget(pb);
        pb.setType("核算");
        List<ProjectBudget> hesuanlist = projectService.getProjectBudget(pb);
        List<Integer> yusuan = new ArrayList<>();
        List<Integer> hesuan = new ArrayList<>();
        if(yusuanlist.size() > 0){
            yusuan.add(yusuanlist.get(0).getValue12());
            yusuan.add(yusuanlist.get(0).getValue01());
            yusuan.add(yusuanlist.get(0).getValue02());
            yusuan.add(yusuanlist.get(0).getValue03());
            yusuan.add(yusuanlist.get(0).getValue04());
            yusuan.add(yusuanlist.get(0).getValue05());
            yusuan.add(yusuanlist.get(0).getValue06());
            yusuan.add(yusuanlist.get(0).getValue07());
            yusuan.add(yusuanlist.get(0).getValue08());
            yusuan.add(yusuanlist.get(0).getValue09());
            yusuan.add(yusuanlist.get(0).getValue10());
            yusuan.add(yusuanlist.get(0).getValue11());
        }
        if(hesuan.size() > 0){
            hesuan.add(hesuanlist.get(0).getValue12());
            hesuan.add(hesuanlist.get(0).getValue01());
            hesuan.add(hesuanlist.get(0).getValue02());
            hesuan.add(hesuanlist.get(0).getValue03());
            hesuan.add(hesuanlist.get(0).getValue04());
            hesuan.add(hesuanlist.get(0).getValue05());
            hesuan.add(hesuanlist.get(0).getValue06());
            hesuan.add(hesuanlist.get(0).getValue07());
            hesuan.add(hesuanlist.get(0).getValue08());
            hesuan.add(hesuanlist.get(0).getValue09());
            hesuan.add(hesuanlist.get(0).getValue10());
            hesuan.add(hesuanlist.get(0).getValue11());
        }
        jsonObject.put("yusuanlist",yusuan);
        jsonObject.put("hesuanlist",hesuan);
        return jsonObject;
    }
    @GetMapping("/getProjectDefect")
    @ResponseBody
    public JSONObject getProjectDefect(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        ProjectDefect pd = new ProjectDefect();
        pd.setProjectCode(projectCode);
        List<ProjectDefect> projectList = projectService.getProjectDefect(pd);
        List<String> stageList = projectList.stream().map(ProjectDefect::getProjectStage).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<Integer> ceShiWentiList = new ArrayList<>();
        List<Integer> shiZHiWenTiList = new ArrayList<>();
        List<Integer> ziCeWenTiList = new ArrayList<>();
        List<ProjectDefect> ceShiWenti = projectList.stream().filter(item -> "测试问题".equals(item.getProjectType())).collect(Collectors.toList());
        for(String stage : stageList){
            List<ProjectDefect> list = ceShiWenti.stream().filter(item -> stage.equals(item.getProjectStage())).collect(Collectors.toList());
            if(list.size() > 0){
                ceShiWentiList.add(list.get(0).getQuestionNum());
            }else{
                ceShiWentiList.add(0);
            }
        }
        List<ProjectDefect> shiZHiWenTi = projectList.stream().filter(item -> "试制问题".equals(item.getProjectType())).collect(Collectors.toList());
        for(String stage : stageList){
            List<ProjectDefect> list = shiZHiWenTi.stream().filter(item -> stage.equals(item.getProjectStage())).collect(Collectors.toList());
            if(list.size() > 0){
                shiZHiWenTiList.add(list.get(0).getQuestionNum());
            }else{
                shiZHiWenTiList.add(0);
            }
        }
        List<ProjectDefect> ziCeWenTi = projectList.stream().filter(item -> "自测问题".equals(item.getProjectType())).collect(Collectors.toList());
        for(String stage : stageList){
            List<ProjectDefect> list = ziCeWenTi.stream().filter(item -> stage.equals(item.getProjectStage())).collect(Collectors.toList());
            if(list.size() > 0){
                ziCeWenTiList.add(list.get(0).getQuestionNum());
            }else{
                ziCeWenTiList.add(0);
            }
        }
        jsonObject.put("ceShiWenti",ceShiWentiList);
        jsonObject.put("shiZHiWenTi",shiZHiWenTiList);
        jsonObject.put("ziCeWenTi",ziCeWenTiList);
        jsonObject.put("stageList",stageList);
        return jsonObject;
    }
    @GetMapping("/getQuestionCloseLoop")
    @ResponseBody
    public JSONObject getQuestionCloseLoop(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        QuestionCloseLoop ql = new QuestionCloseLoop();
        ql.setProjectCode(projectCode);
        List<QuestionCloseLoop> questionCloseLoopList = projectService.getQuestionCloseLoop(ql);
        List<String> stageList = questionCloseLoopList.stream().map(QuestionCloseLoop::getProjectState).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());

        List<Integer> ceShiWentiList = new ArrayList<>();
        List<Integer> shiZHiWenTiList = new ArrayList<>();
        List<Integer> ziCeWenTiList = new ArrayList<>();
        List<QuestionCloseLoop> ceShiWenti = questionCloseLoopList.stream().filter(item -> "测试问题".equals(item.getProjectType())).collect(Collectors.toList());
        for(String stage : stageList){
            List<QuestionCloseLoop> list = ceShiWenti.stream().filter(item -> stage.equals(item.getProjectState())).collect(Collectors.toList());
            if(list.size() > 0){
                ceShiWentiList.add(list.get(0).getQuestionNum());
            }else{
                ceShiWentiList.add(0);
            }
        }
        List<QuestionCloseLoop> shiZHiWenTi = questionCloseLoopList.stream().filter(item -> "试制问题".equals(item.getProjectType())).collect(Collectors.toList());
        for(String stage : stageList){
            List<QuestionCloseLoop> list = shiZHiWenTi.stream().filter(item -> stage.equals(item.getProjectState())).collect(Collectors.toList());
            if(list.size() > 0){
                shiZHiWenTiList.add(list.get(0).getQuestionNum());
            }else{
                shiZHiWenTiList.add(0);
            }
        }
        List<QuestionCloseLoop> ziCeWenTi = questionCloseLoopList.stream().filter(item -> "自测问题".equals(item.getProjectType())).collect(Collectors.toList());
        for(String stage : stageList){
            List<QuestionCloseLoop> list = ziCeWenTi.stream().filter(item -> stage.equals(item.getProjectState())).collect(Collectors.toList());
            if(list.size() > 0){
                ziCeWenTiList.add(list.get(0).getQuestionNum());
            }else{
                ziCeWenTiList.add(0);
            }
        }
        jsonObject.put("ceShiWenti",ceShiWentiList);
        jsonObject.put("shiZHiWenTi",shiZHiWenTiList);
        jsonObject.put("ziCeWenTi",ziCeWenTiList);
        jsonObject.put("stageList",stageList);
        return jsonObject;
    }
    @GetMapping("/getProjectList")
    @ResponseBody
    public JSONObject getProjectList()
    {
        JSONObject jsonObject = new JSONObject();
        List<Project> projectList = projectService.getProject();
        jsonObject.put("projectList",projectList);
        return jsonObject;
    }
    @GetMapping("/getSourceInve")
    @ResponseBody
    public JSONObject getSourceInve(String year,String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        SourceInve sourceInve = new SourceInve();
        sourceInve.setYear(year);
        sourceInve.setProjectCode(projectCode);
        List<SourceInve> sourceInveList = projectService.getSourceInve(sourceInve);

        List<String> monthlist = sourceInveList.stream().map(SourceInve::getMonth).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<SourceInve> yingJianList = sourceInveList.stream().filter(item -> "硬件".equals(item.getSourceType())).collect(Collectors.toList());
        List<Float> yingJian = new ArrayList<>();
        for(String month : monthlist){
            List<SourceInve> monthNumList = yingJianList.stream().filter(item -> month.equals(item.getMonth())).collect(Collectors.toList());
            if(monthNumList.size() > 0){
                yingJian.add(monthNumList.get(0).getInveNum());
            }else{
                yingJian.add((float) 0);
            }
        }

        List<SourceInve> ruanJianList = sourceInveList.stream().filter(item -> "软件".equals(item.getSourceType())).collect(Collectors.toList());
        List<Float> ruanJian = new ArrayList<>();
        for(String month : monthlist){
            List<SourceInve> monthNumList = ruanJianList.stream().filter(item -> month.equals(item.getMonth())).collect(Collectors.toList());
            if(monthNumList.size() > 0){
                ruanJian.add(monthNumList.get(0).getInveNum());
            }else{
                ruanJian.add((float) 0);
            }
        }
        jsonObject.put("ruanJian",ruanJian);
        jsonObject.put("yingJian",yingJian);
        jsonObject.put("monthlist",monthlist);
        return jsonObject;
    }
    @GetMapping("/getProjectKeyQuestion")
    @ResponseBody
    public JSONObject getProjectKeyQuestion(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        ProjectKeyQuestion pkq = new ProjectKeyQuestion();
        pkq.setProjectCode(projectCode);
        List<ProjectKeyQuestion> projectList = projectService.getProjectKeyQuestion(pkq);
        jsonObject.put("ProjectKeyQuestion",projectList);

        ProjectProcess pp = new ProjectProcess();
        pp.setProjectCode(projectCode);
        List<ProjectProcess> projectProcessList = projectService.getProjectProcess(pp);
        jsonObject.put("projectProcessList",projectProcessList);
        return jsonObject;
    }
    @GetMapping("/getProjectPlan")
    @ResponseBody
    public JSONObject getProjectPlan(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        ProjectPlan pp = new ProjectPlan();
        pp.setProjectCode(projectCode);
        List<ProjectPlan> projectPlanList = projectService.getProjectPlan(pp);
        jsonObject.put("projectPlanList",projectPlanList);
        Cost cost = new Cost();
        cost.setProjectCode(projectCode);
        cost = projectService.getCostRate(cost);
        jsonObject.put("cost",cost);
        return jsonObject;
    }
    @GetMapping("/getProjectProcess")
    @ResponseBody
    public JSONObject getProjectProcess(String projectCode)
    {
        JSONObject jsonObject = new JSONObject();
        ProjectProcess pp = new ProjectProcess();
        pp.setProjectCode(projectCode);
        List<ProjectProcess> projectProcessList = projectService.getProjectProcess(pp);
        jsonObject.put("projectProcessList",projectProcessList);
        return jsonObject;
    }
}
