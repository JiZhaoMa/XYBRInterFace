package com.ruoyi.u9c.service.impl;

import com.ruoyi.u9c.domain.SaleContract;
import com.ruoyi.u9c.mapper.SaleContractBPMMapper;
import com.ruoyi.u9c.service.ARBillBpmServive;
import com.ruoyi.u9c.service.SaleContractBPMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleContractServiveImpl implements SaleContractBPMService {
    @Autowired
    SaleContractBPMMapper saleContractBPMMapper;

    @Override
    public int insertSaleContrace(List<SaleContract> list) {
        int result = saleContractBPMMapper.deletSaleContrace();
        if(result >= 0){
            return saleContractBPMMapper.insertSaleContrace(list);
        }
        return 0;
    }
}
