package com.ruoyi.report.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/report/plan")
public class ProductPlanController {
    private String prefix = "report";
    //@RequiresPermissions("report:productPlan:view")
    @GetMapping("/getProductPlan")
    public String getProductPlan()
    {
        ModelMap mmap = new ModelMap();
        mmap.put("", "");
        return prefix + "/productPlan";
    }
}
