package com.ruoyi.u9c;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.u9c.domain.ARBill;
import com.ruoyi.u9c.domain.InvTrans;
import com.ruoyi.u9c.domain.Voucher;
import com.ruoyi.u9c.service.*;
import com.ruoyi.u9c.service.impl.ARBillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component("u9cTask")
public class U9CTask {
    @Autowired
    InvTransService invTransService;
    @Autowired
    InvTransBpmServive invTransBpmServive;
    @Autowired
    ARBillServiceImpl arBillService;
    @Autowired
    ARBillBpmServive arBillBpmServive;
    @Autowired
    VoucherService voucherService;
    @Autowired
    VoucherBpmService voucherBpmService;
    public void getItemInfoList() {
        List<InvTrans> list = invTransService.getInvTransList();
        if(list.size() > 0){
            //删除料品库存历史信息
            invTransBpmServive.deleteInvTransHis();
            //插入历史信息表
            invTransBpmServive.insertInvTransHis(list);
            //删除料品库存
            invTransBpmServive.deleteInvTrans();
            //插入料品库存表
            invTransBpmServive.insertInvTrans(list);
        }
    }

    public void getARBillList(String year, String month){
        if(StringUtils.isEmpty(year) || StringUtils.isEmpty(month)){
            LocalDate today = LocalDate.now();
            int monthInt = today.getMonthValue();
            if(monthInt == 1){
                year = String.valueOf(today.getYear() -1);
                month = "12";
            }else if(monthInt < 10 && monthInt > 1){
                year = String.valueOf(today.getYear());
                monthInt = monthInt - 1;
                month = "0"+monthInt;
            }else{
                year = String.valueOf(today.getYear());
                monthInt = monthInt - 1;
                month = String.valueOf(monthInt);
            }
            System.out.println(today);
        }
        List<ARBill> list = arBillService.getARBill(year,month);
        if(list.size() > 0){
            arBillBpmServive.deleteARBill(year +'-'+ month);
            arBillBpmServive.insertARBill(list);
            arBillBpmServive.updateARBill(year +'-'+ month);
        }
        System.out.println(list);
    }
    public void getVoucherList(String year, String month){
        if(StringUtils.isEmpty(year) || StringUtils.isEmpty(month)){
            LocalDate today = LocalDate.now();
            int monthInt = today.getMonthValue();
            if(monthInt == 1){
                year = String.valueOf(today.getYear() -1);
                month = "12";
            }else if(monthInt < 10 && monthInt > 1){
                year = String.valueOf(today.getYear());
                monthInt = monthInt - 1;
                month = "0"+monthInt;
            }else{
                year = String.valueOf(today.getYear());
                monthInt = monthInt - 1;
                month = String.valueOf(monthInt);
            }
            System.out.println(today);
        }
        List<Voucher> list = voucherService.getVoucher(year +'-'+ month);
        if(list.size() > 0){
            voucherBpmService.deleteVoucher(year +'-'+ month);
            voucherBpmService.insertVoucher(list);
            int sumMoney = 0;
            for(Voucher voucher: list){
                sumMoney += voucher.getSumMoney();
            }
            voucherBpmService.updateVoucher(year +'-'+ month, sumMoney);
        }
        System.out.println(list);
    }
}
