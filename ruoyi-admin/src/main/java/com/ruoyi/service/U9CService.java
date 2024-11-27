package com.ruoyi.service;

import com.ruoyi.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface U9CService {
    public List<Department> getU9CDeptByName(String name);
    public Department getDepartCode(Department d);
    public List<User> getU9CUserInfo(User user);
    public int updateU9CUserInfo(User user);
    public List<FixedFiled> getU9CFixedFiled();
    public List<Supplier> getU9CSupplier();
    public String getAssetCode(@Param("assetCard") String assetCard);
    public int updateOrderCode(@Param("newOrderCode") String newOrderCode,@Param("orderCode") String orderCode);
    public int updateLotCode(@Param("lotCode") String lotCode,@Param("orderCode") String orderCode,@Param("itemCode") String itemCode,@Param("docLineNo") int docLineNo,@Param("deliveryDate") String deliveryDate);
    public ArriveQty selectArriveQty(ArriveQty arriveQty);
}
