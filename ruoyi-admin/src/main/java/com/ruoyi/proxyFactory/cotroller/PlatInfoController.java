package com.ruoyi.proxyFactory.cotroller;

import java.util.List;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.proxyFactory.domain.PlatInfo;
import com.ruoyi.proxyFactory.service.IPlatInfoService;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2024-12-25
 */
@Controller
@RequestMapping("/plat/info")
public class PlatInfoController extends BaseController
{
    private String prefix = "proxyFactory";

    @Autowired
    private IPlatInfoService platInfoService;

    @RequiresPermissions("plat:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("plat:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PlatInfo platInfo)
    {
        startPage();
        List<PlatInfo> list = platInfoService.selectPlatInfoList(platInfo);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("plat:info:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PlatInfo platInfo)
    {
        List<PlatInfo> list = platInfoService.selectPlatInfoList(platInfo);
        ExcelUtil<PlatInfo> util = new ExcelUtil<PlatInfo>(PlatInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("plat:info:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PlatInfo platInfo)
    {
        return toAjax(platInfoService.insertPlatInfo(platInfo));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{platName}")
    public String edit(@PathVariable("platName") String platName, ModelMap mmap)
    {
        PlatInfo platInfo = platInfoService.selectPlatInfoById(platName);
        mmap.put("platInfo", platInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("plat:info:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PlatInfo platInfo)
    {
        return toAjax(platInfoService.updatePlatInfo(platInfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("plat:info:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(platInfoService.deletePlatInfoByIds(ids));
    }
}
