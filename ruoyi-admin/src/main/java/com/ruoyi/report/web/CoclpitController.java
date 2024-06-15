package com.ruoyi.report.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.report.domain.XybrOrder;
import com.ruoyi.report.service.IXybrOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;

/**
 * XybrOrderController
 * @author ruoyi
 * @date 2024-03-19
 */
@Controller
@RequestMapping("/system/cockpit")
public class CoclpitController extends BaseController
{
    private String prefix = "report/businessManagementCockpit";
    @GetMapping("/getView")
    public String XybrOrder()
    {
        return prefix + "/cockpit001";
    }
}
