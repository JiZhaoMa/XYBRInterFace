package com.ruoyi.task;

import com.ruoyi.api.util.Mail;
import com.ruoyi.domain.PatentRemind;
import com.ruoyi.service.BPMService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*@Component("bpmTask")*/
public class BpmTask {
    private static final Logger log = LoggerFactory.getLogger(BpmTask.class);
    @Autowired
    BPMService bpmService;
    @Autowired
    Mail mail;
    public void patentPayRemind(){
        List<PatentRemind> list = bpmService.getPatentList();
        if(!list.isEmpty()){
            StringBuilder tableHtml = new StringBuilder();
            tableHtml.append("<table border='1'>");
            tableHtml.append("<tr>");
            tableHtml.append("<td>").append("受理通知书申请号").append("</td>");
            tableHtml.append("<td>").append("最晚缴费日期").append("</td>");
            tableHtml.append("</tr>");
            for(PatentRemind pr : list){
                tableHtml.append("<tr>");
                tableHtml.append("<td>").append(pr.getPatentNo()).append("</td>");
                tableHtml.append("<td>").append(pr.getPayDate()).append("</td>");
                tableHtml.append("</tr>");
            }
            tableHtml.append("</table>");
            String emailContent = "<html><body><h3>您好，本月待缴专利年费信息如下：</h3>" +
                    tableHtml.toString() +
                    "</body></html>";
            mail.sendMail(list.get(0).getMailTo(),"专利年费缴纳提醒！",emailContent);
        }
    }
}
