package com.ruoyi.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.domain.*;
import com.ruoyi.u9c.domain.POLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BPMService {
    public List<Department> getDepartList(int level);
    public int updateDeptU9CCode(Department department);
    public int updateUserInfoDeptU9CCode(List<User> list);
    public List<User> getUserList();
    public int insertFixedFiled(List<FixedFiled> list);
    public int insertSupplier(List<Supplier> list);
    public JSONObject getPOLine(List<String> list,List<String> idsList,String PurDeptCode,String PurOperCode);
    public List<ArriveQty> getCaiGouDetail();
    public int updateArriveQty(ArriveQty arriveQty);
}
