package com.ruoyi.u9c.web;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.report.domain.selfTest.PriorityQuestion;
import com.ruoyi.report.service.SelfTestService;
import com.ruoyi.service.U9CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/interface/u9c")
public class U9CController extends BaseController {


    @Autowired
    private U9CService u9CService;
    @GetMapping("/getAssetCode/{assetCard}")
    @ResponseBody
    public JSONObject getAssetCode(@PathVariable("assetCard")String assetCard)
    {
        String assCode = u9CService.getAssetCode(assetCard);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("assCode",assCode);
        return jsonObject;
    }
}
