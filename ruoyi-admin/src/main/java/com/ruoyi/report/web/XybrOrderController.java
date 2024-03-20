package com.ruoyi.report.web;

import java.util.Comparator;
import java.util.List;

import com.ruoyi.report.domain.AgentOrder;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.report.domain.XybrOrder;
import com.ruoyi.report.service.IXybrOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * XybrOrderController
 * @author ruoyi
 * @date 2024-03-19
 */
@Controller
@RequestMapping("/system/xybrOrder")
public class XybrOrderController extends BaseController
{
    private String prefix = "system/xybrOrder";

    @Autowired
    private IXybrOrderService XybrOrderService;

    @GetMapping("/getListView")
    public String XybrOrder()
    {
        return prefix + "/list";
    }

    /**
     * 查询【工单】列表
     */
    @PostMapping("/list")
    @ResponseBody
    public List<XybrOrder> list(XybrOrder XybrOrder)
    {
        startPage();
        List<XybrOrder> list = XybrOrderService.selectXybrOrderList(XybrOrder);
        List<XybrOrder> agentOrderList = XybrOrderService.selectAgentOrderList(XybrOrder);
        list.addAll(agentOrderList);
        list.sort(Comparator.comparing(com.ruoyi.report.domain.XybrOrder::getXybrProductOrder));
        return list;
    }
}
