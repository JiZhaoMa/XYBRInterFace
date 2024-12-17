package com.ruoyi.report.mapper;


import com.ruoyi.report.domain.patent.Patents;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatentMapper {
    List<Patents> getPatentDetail(@Param("dept") String dept,@Param("person") String person,@Param("ptype") String ptype,@Param("process") String process,@Param("jiaoDiShuMonth") String jiaoDiShuMonth,@Param("shouQuanMonth") String shouQuanMonth);
    List<Patents> getPatentAppType(@Param("dept") String dept,@Param("person") String person,@Param("ptype") String ptype,@Param("process") String process,@Param("jiaoDiShuMonth") String jiaoDiShuMonth,@Param("shouQuanMonth") String shouQuanMonth);
    List<Patents> getPatentByType(@Param("dept") String dept,@Param("person") String person,@Param("ptype") String ptype,@Param("process") String process,@Param("jiaoDiShuMonth") String jiaoDiShuMonth,@Param("shouQuanMonth") String shouQuanMonth);
    List<Patents> getPatentByDept(@Param("dept") String dept,@Param("person") String person,@Param("ptype") String ptype,@Param("process") String process,@Param("jiaoDiShuMonth") String jiaoDiShuMonth,@Param("shouQuanMonth") String shouQuanMonth);
    List<Patents> getPatentByPerson(@Param("dept") String dept,@Param("person") String person,@Param("ptype") String ptype,@Param("process") String process,@Param("jiaoDiShuMonth") String jiaoDiShuMonth,@Param("shouQuanMonth") String shouQuanMonth);
    List<Patents> getPatentByProxy(@Param("dept") String dept,@Param("person") String person,@Param("ptype") String ptype,@Param("process") String process,@Param("jiaoDiShuMonth") String jiaoDiShuMonth,@Param("shouQuanMonth") String shouQuanMonth);
    List<Patents> getPatentByYear(@Param("dept") String dept,@Param("person") String person);
}
