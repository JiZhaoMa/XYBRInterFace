package com.ruoyi.api.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.ruoyi.api.domian.MesPassRecords;
import com.ruoyi.api.service.MesPassRecordsService;
import com.ruoyi.api.util.TokenValidation;
import com.ruoyi.common.core.domain.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/XYBR/mes")
@RestController
public class MesPassRecordsController {
    private Logger logger = LoggerFactory.getLogger(MesPassRecordsController.class);
    @Autowired
    MesPassRecordsService mesPassRecordsService;
    /**
     * 原材料入库
     * @param
     * @return
     */
    @PostMapping("/passRecords/stats")
    @TokenValidation
    public AjaxResult handleMaterial(@RequestBody JSONArray param) throws Exception {
        logger.info("【第三方对接平台调用过站记录信息接口】请求参数：{}",param);
        try{
            System.out.println("转换之前的数据量：" + param.size());
            List<MesPassRecords> list = param.toJavaList(MesPassRecords.class);
            System.out.println("转换之后的数据量：" + list.size());
            mesPassRecordsService.insertRecords(list);
        }catch (Exception e){
            return AjaxResult.error(e.getMessage(),null);
        }
        return AjaxResult.success("过站记录信息接口调用成功！",null);
    }
}
