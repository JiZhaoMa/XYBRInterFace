package com.ruoyi.report.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.report.domain.selfTest.PriorityQuestion;
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
    private SelfTestService selfTestService;
    @GetMapping("/getProjectSingle")
    public String getProjectSingle()
    {
        return prefix + "/projectSingle";
    }
    @GetMapping("/getPriorityQues")
    @ResponseBody
    public JSONObject getPriorityQues(String project)
    {
        JSONObject jsonObject = new JSONObject();
        List<PriorityQuestion> list = selfTestService.getPriorityQues(project);
        return jsonObject;
    }
}
