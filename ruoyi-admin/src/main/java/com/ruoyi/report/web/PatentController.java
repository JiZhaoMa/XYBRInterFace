package com.ruoyi.report.web;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.report.domain.cockpit.AnShiJiaoFu;
import com.ruoyi.report.domain.patent.Patents;
import com.ruoyi.report.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/report/patent")
public class PatentController extends BaseController {
    private String prefix = "report/patent";

    @Autowired
    private PatentService patentService;
    @GetMapping("/getPatent")
    public String getProjectSingle()
    {
        return prefix + "/patent";
    }
    @GetMapping("/getAppType")
    @ResponseBody
    public JSONObject getAppType(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth)
    {
        JSONObject jsonObject = new JSONObject();
        List<Patents> list = patentService.getPatentAppType(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);;
        JSONArray jsonArray = new JSONArray();
        for(Patents patents : list){
            JSONObject json = new JSONObject();
            json.put("name",patents.getAppType());
            json.put("value",patents.getAppNumber());
            jsonArray.add(json);
        }
        jsonObject.put("appTypeJsonArr",jsonArray);
        return jsonObject;
    }
    @GetMapping("/getPatentByType")
    @ResponseBody
    public JSONObject getPatentByType(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth)
    {
        JSONObject jsonObject = new JSONObject();
        List<Patents> list = patentService.getPatentByType(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
        List<String> processList = list.stream().map(Patents::getProcess).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        jsonObject.put("xAxisData",processList);
        List<Patents> faMingList = list.stream().filter(item -> "发明".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> shiYongList = list.stream().filter(item -> "实用新型".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> waiGuanList = list.stream().filter(item -> "外观设计".equals(item.getAppType())).collect(Collectors.toList());
        List<Integer> faMingData = new ArrayList<>();
        List<Integer> shiYongData = new ArrayList<>();
        List<Integer> waiGuanData = new ArrayList<>();
        for(String pro : processList){
            List<Patents> faMingProcessList = faMingList.stream().filter(item -> pro.equals(item.getProcess())).collect(Collectors.toList());
            int famingNum = 0;
            for(Patents p : faMingProcessList){
                famingNum += p.getAppNumber();
            }
            faMingData.add(famingNum);
            List<Patents> shiYongProcessList = shiYongList.stream().filter(item -> pro.equals(item.getProcess())).collect(Collectors.toList());
            int shiYongNum = 0;
            for(Patents p : shiYongProcessList){
                shiYongNum += p.getAppNumber();
            }
            shiYongData.add(shiYongNum);
            List<Patents> waiGuanProcessList = waiGuanList.stream().filter(item -> pro.equals(item.getProcess())).collect(Collectors.toList());
            int waiGuanNum = 0;
            for(Patents p : waiGuanProcessList){
                waiGuanNum += p.getAppNumber();
            }
            waiGuanData.add(waiGuanNum);
        }
        jsonObject.put("faMingData",faMingData);
        jsonObject.put("shiYongData",shiYongData);
        jsonObject.put("waiGuanData",waiGuanData);
        return jsonObject;
    }
    @GetMapping("/getPatentByDept")
    @ResponseBody
    public JSONObject getPatentByDept(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth)
    {
        JSONObject jsonObject = new JSONObject();
        List<Patents> list = patentService.getPatentByDept(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
        List<String> deptList = list.stream().map(Patents::getDept).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<Integer> faMingData = new ArrayList<>();
        List<Integer> shiYongData = new ArrayList<>();
        List<Integer> waiGuanData = new ArrayList<>();
        List<Patents> faMingList = list.stream().filter(item -> "发明".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> shiYongList = list.stream().filter(item -> "实用新型".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> waiGuanList = list.stream().filter(item -> "外观设计".equals(item.getAppType())).collect(Collectors.toList());
        for(String d : deptList){
            List<Patents> faMingDeptList = faMingList.stream().filter(item -> d.equals(item.getDept())).collect(Collectors.toList());
            int famingNum = 0;
            for(Patents p : faMingDeptList){
                famingNum += p.getAppNumber();
            }
            faMingData.add(famingNum);
            List<Patents> shiYongDeptList = shiYongList.stream().filter(item -> d.equals(item.getDept())).collect(Collectors.toList());
            int shiYongNum = 0;
            for(Patents p : shiYongDeptList){
                shiYongNum += p.getAppNumber();
            }
            shiYongData.add(shiYongNum);
            List<Patents> waiGuanDeptList = waiGuanList.stream().filter(item -> d.equals(item.getDept())).collect(Collectors.toList());
            int waiGuanNum = 0;
            for(Patents p : waiGuanDeptList){
                waiGuanNum += p.getAppNumber();
            }
            waiGuanData.add(waiGuanNum);
        }
        jsonObject.put("xAxisData",deptList);
        jsonObject.put("faMingData",faMingData);
        jsonObject.put("shiYongData",shiYongData);
        jsonObject.put("waiGuanData",waiGuanData);
        return jsonObject;
    }
    @GetMapping("/getPatentByPerson")
    @ResponseBody
    public JSONObject getPatentByPerson(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth)
    {
        JSONObject jsonObject = new JSONObject();
        List<Patents> list = patentService.getPatentByPerson(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
        List<String> personList = list.stream().map(Patents::getPerson).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<Integer> faMingData = new ArrayList<>();
        List<Integer> shiYongData = new ArrayList<>();
        List<Integer> waiGuanData = new ArrayList<>();
        List<Patents> faMingList = list.stream().filter(item -> "发明".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> shiYongList = list.stream().filter(item -> "实用新型".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> waiGuanList = list.stream().filter(item -> "外观设计".equals(item.getAppType())).collect(Collectors.toList());
        for(String per : personList){
            List<Patents> faMingPersonList = faMingList.stream().filter(item -> per.equals(item.getPerson())).collect(Collectors.toList());
            int famingNum = 0;
            for(Patents p : faMingPersonList){
                famingNum += p.getAppNumber();
            }
            faMingData.add(famingNum);
            List<Patents> shiYongPersonList = shiYongList.stream().filter(item -> per.equals(item.getPerson())).collect(Collectors.toList());
            int shiYongNum = 0;
            for(Patents p : shiYongPersonList){
                shiYongNum += p.getAppNumber();
            }
            shiYongData.add(shiYongNum);
            List<Patents> waiGuanPersonList = waiGuanList.stream().filter(item -> per.equals(item.getPerson())).collect(Collectors.toList());
            int waiGuanNum = 0;
            for(Patents p : waiGuanPersonList){
                waiGuanNum += p.getAppNumber();
            }
            waiGuanData.add(waiGuanNum);
        }
        jsonObject.put("xAxisData",personList);
        jsonObject.put("faMingData",faMingData);
        jsonObject.put("shiYongData",shiYongData);
        jsonObject.put("waiGuanData",waiGuanData);
        return jsonObject;
    }
    @GetMapping("/getPatentByProxy")
    @ResponseBody
    public JSONObject getPatentByProxy(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth)
    {
        JSONObject jsonObject = new JSONObject();
        List<Patents> list = patentService.getPatentByProxy(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
        List<String> proxyList = list.stream().map(Patents::getProxy).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<Integer> faMingData = new ArrayList<>();
        List<Integer> shiYongData = new ArrayList<>();
        List<Integer> waiGuanData = new ArrayList<>();
        List<Patents> faMingList = list.stream().filter(item -> "发明".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> shiYongList = list.stream().filter(item -> "实用新型".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> waiGuanList = list.stream().filter(item -> "外观设计".equals(item.getAppType())).collect(Collectors.toList());
        for(String proxy : proxyList){
            List<Patents> faMingProxyList = faMingList.stream().filter(item -> proxy.equals(item.getProxy())).collect(Collectors.toList());
            int famingNum = 0;
            for(Patents p : faMingProxyList){
                famingNum += p.getAppNumber();
            }
            faMingData.add(famingNum);
            List<Patents> shiYongProxyList = shiYongList.stream().filter(item -> proxy.equals(item.getProxy())).collect(Collectors.toList());
            int shiYongNum = 0;
            for(Patents p : shiYongProxyList){
                shiYongNum += p.getAppNumber();
            }
            shiYongData.add(shiYongNum);
            List<Patents> waiGuanProxyList = waiGuanList.stream().filter(item -> proxy.equals(item.getProxy())).collect(Collectors.toList());
            int waiGuanNum = 0;
            for(Patents p : waiGuanProxyList){
                waiGuanNum += p.getAppNumber();
            }
            waiGuanData.add(waiGuanNum);
        }
        jsonObject.put("xAxisData",proxyList);
        jsonObject.put("faMingData",faMingData);
        jsonObject.put("shiYongData",shiYongData);
        jsonObject.put("waiGuanData",waiGuanData);
        return jsonObject;
    }
    @GetMapping("/getPatentByYear")
    @ResponseBody
    public JSONObject getPatentByYear(String dept,String person)
    {
        JSONObject jsonObject = new JSONObject();
        List<Patents> list = patentService.getPatentByYear(dept,person);
        List<String> yearList = list.stream().map(Patents::getYear).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<Integer> faMingData = new ArrayList<>();
        List<Integer> shiYongData = new ArrayList<>();
        List<Integer> waiGuanData = new ArrayList<>();
        List<Patents> faMingList = list.stream().filter(item -> "发明".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> shiYongList = list.stream().filter(item -> "实用新型".equals(item.getAppType())).collect(Collectors.toList());
        List<Patents> waiGuanList = list.stream().filter(item -> "外观设计".equals(item.getAppType())).collect(Collectors.toList());
        for(String year : yearList){
            List<Patents> faMingYearList = faMingList.stream().filter(item -> year.equals(item.getYear())).collect(Collectors.toList());
            int famingNum = 0;
            for(Patents p : faMingYearList){
                famingNum += p.getAppNumber();
            }
            faMingData.add(famingNum);
            List<Patents> shiYongYearList = shiYongList.stream().filter(item -> year.equals(item.getYear())).collect(Collectors.toList());
            int shiYongNum = 0;
            for(Patents p : shiYongYearList){
                shiYongNum += p.getAppNumber();
            }
            shiYongData.add(shiYongNum);
            List<Patents> waiGuanYearList = waiGuanList.stream().filter(item -> year.equals(item.getYear())).collect(Collectors.toList());
            int waiGuanNum = 0;
            for(Patents p : waiGuanYearList){
                waiGuanNum += p.getAppNumber();
            }
            waiGuanData.add(waiGuanNum);
        }
        jsonObject.put("xAxisData",yearList);
        jsonObject.put("faMingData",faMingData);
        jsonObject.put("shiYongData",shiYongData);
        jsonObject.put("waiGuanData",waiGuanData);
        return jsonObject;
    }
    @GetMapping("/getPatentDetail")
    @ResponseBody
    public JSONObject getPatentDetail(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth)
    {
        JSONObject jsonObject = new JSONObject();
        List<Patents> plist = patentService.getPatentByPerson("","","","","","");
        List<String> personList = plist.stream().map(Patents::getPerson).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<Patents> dlist = patentService.getPatentByDept("","","","","","");
        List<String> deptList = dlist.stream().map(Patents::getDept).collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
        List<Patents> list = patentService.getPatentDetail(dept,person,ptype,process,jiaoDiShuMonth,shouQuanMonth);
        int countNum = 0;
        int cheAnNum = 0;
        int xiaZhengNum = 0;
        int boHuiNum = 0;
        int shouQuanDaiFa = 0;
        for(Patents p : list){
            if("撤案".equals(p.getProcess())){
                cheAnNum = p.getAppNumber();
            }
            if("驳回".equals(p.getProcess())){
                boHuiNum = p.getAppNumber();
            }
            if("授权待发证".equals(p.getProcess())){
                shouQuanDaiFa = p.getAppNumber();
            }
            if("发证".equals(p.getProcess())){
                xiaZhengNum = p.getAppNumber();
            }
            countNum += p.getAppNumber();
        }
        jsonObject.put("personList",personList);
        jsonObject.put("deptList",deptList);
        jsonObject.put("countNum",countNum);
        jsonObject.put("cheAnNum",cheAnNum);
        jsonObject.put("xiaZhengNum",xiaZhengNum);
        jsonObject.put("boHuiNum",boHuiNum);
        jsonObject.put("shouQuanDaiFa",shouQuanDaiFa);
        return jsonObject;
    }
}
