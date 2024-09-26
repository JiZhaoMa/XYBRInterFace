package com.ruoyi.u9c.mapper;

import com.ruoyi.u9c.domain.InvTrans;

import java.util.List;

public interface InvTransBpmMapper {
    public int insertInvTransHis(List<InvTrans> list);
    public int insertInvTrans(List<InvTrans> list);
    public int deleteInvTrans();
    public int deleteInvTransHis();
}
