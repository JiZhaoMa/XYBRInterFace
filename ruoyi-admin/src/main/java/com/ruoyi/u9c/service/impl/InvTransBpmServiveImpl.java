package com.ruoyi.u9c.service.impl;

import com.ruoyi.u9c.domain.InvTrans;
import com.ruoyi.u9c.mapper.InvTransBpmMapper;
import com.ruoyi.u9c.service.InvTransBpmServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvTransBpmServiveImpl implements InvTransBpmServive {
    @Autowired
    InvTransBpmMapper invTransBpmMapper;

    @Override
    public int insertInvTransHis(List<InvTrans> list) {
        return invTransBpmMapper.insertInvTransHis(list);
    }

    @Override
    public int insertInvTrans(List<InvTrans> list) {
        return invTransBpmMapper.insertInvTrans(list);
    }

    @Override
    public int deleteInvTrans() {
        return invTransBpmMapper.deleteInvTrans();
    }

    @Override
    public int deleteInvTransHis() {
        return invTransBpmMapper.deleteInvTransHis();
    }
}
