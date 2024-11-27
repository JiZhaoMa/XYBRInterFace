package com.ruoyi.report.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.report.domain.project.EcLedger;
import com.ruoyi.report.domain.project.Project;
import com.ruoyi.report.domain.selfTest.PriorityQuestion;
import com.ruoyi.report.service.ProjectService;
import com.ruoyi.report.service.SelfTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        List<EcLedger> list = projectService.getEcLedger(ecLedger);
        jsonObject.put("ecList",list);
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
}
