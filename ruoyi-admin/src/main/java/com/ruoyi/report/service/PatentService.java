package com.ruoyi.report.service;


import com.ruoyi.report.domain.patent.Patents;

import java.util.List;

public interface PatentService {
    List<Patents> getPatentDetail(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth);
    List<Patents> getPatentAppType(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth);
    List<Patents> getPatentByType(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth);
    List<Patents> getPatentByDept(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth);
    List<Patents> getPatentByPerson(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth);
    List<Patents> getPatentByProxy(String dept,String person,String ptype,String process,String jiaoDiShuMonth,String shouQuanMonth);
    List<Patents> getPatentByYear(String dept,String person);
}
