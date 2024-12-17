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
    public List<POLine> getPOLine(@Param("list") List<String> list,@Param("idsList") List<String> idsList);
    public List<String> getProject(@Param("list") List<String> list,@Param("idsList") List<String> idsList);
    public List<String> getSupplier(@Param("list") List<String> list,@Param("idsList") List<String> idsList);
    public List<String> getCaiGouType(@Param("list") List<String> list,@Param("idsList") List<String> idsList);
    public int updateCaiGouDetail(@Param("pOLineList") List<POLine> pOLineList,@Param("codeList") List<String> codeList,@Param("orderCode") String orderCode,@Param("supplier") String supplier);
    public List<ArriveQty> getCaiGouDetail();
    public int updateArriveQty(ArriveQty arriveQty);
}
