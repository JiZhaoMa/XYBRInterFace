package com.ruoyi.mapper;

import com.ruoyi.domain.*;
import com.ruoyi.u9c.domain.POLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BPMMapper {
    public List<Department> getDepartList(@Param("level") int level);
    public int updateDeptU9CCode(Department department);
    public int updateUserInfoDeptU9CCode(List<User> list);
    public List<User> getUserList();
    public int insertFixedFiled(List<FixedFiled> list);
    public int insertSupplier(List<Supplier> list);
    public int deleteFixedFiled();
    public int deleteSupplier();
    public List<POLine> getPOLine(List<String> list);
    public List<String> getProject(List<String> list);
    public List<String> getSupplier(List<String> list);
    public List<String> getCaiGouType(List<String> list);
    public int updateCaiGouDetail(@Param("pOLineList") List<POLine> pOLineList,@Param("codeList") List<String> codeList,@Param("orderCode") String orderCode,@Param("supplier") String supplier);
    public List<ArriveQty> getCaiGouDetail();
    public int updateArriveQty(ArriveQty arriveQty);
}
