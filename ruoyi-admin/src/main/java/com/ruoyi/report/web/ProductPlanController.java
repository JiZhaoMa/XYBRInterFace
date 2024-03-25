package com.ruoyi.report.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.report.domain.ProductPlanOfMonth;
import com.ruoyi.report.domain.XybrOrder;
import com.ruoyi.report.service.ProductPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/report/plan")
public class ProductPlanController extends BaseController {

    @Autowired
    private ProductPlanService productPlanService;
    private String prefix = "report/product";
    //@RequiresPermissions("report:productPlan:view")
    @GetMapping("/getProductPlan")
    public String getProductPlan()
    {
        ModelMap mmap = new ModelMap();
        mmap.put("", "");
        return prefix + "/productPlan";
    }
    @GetMapping("/getProductPlanOfMonth/{month}/{agent}")
    public String getProductPlanOfMonth(@PathVariable("month") String month,@PathVariable("agent") String agent, ModelMap mmap)
    {
        mmap.put("month",month);
        mmap.put("agentName",agent);
        return prefix + "/planMonthList";
    }
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ProductPlanOfMonth productPlanOfMonth)
    {
        startPage();
        List<ProductPlanOfMonth> list = productPlanService.selectproductPlanOfMonthList(productPlanOfMonth);
        list.addAll(list);
        list.addAll(list);
        return getDataTable(list);
    }
}
