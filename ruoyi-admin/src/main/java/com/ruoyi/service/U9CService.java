package com.ruoyi.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.domain.*;
import com.ruoyi.u9c.domain.ItemInfo;
import com.ruoyi.u9c.domain.ItemLotCodeInfo;
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
    public ItemInfo selectPriceInfoOfXyPurch(ItemInfo itemInfo); //自采物料单价
    public ItemInfo selectPriceInfoOfProxyPurch(ItemInfo itemInfo); //代采物料单价
    public ItemInfo selectPriceInfoOfRdmStage(ItemInfo itemInfo); //研发阶段的物料单价
    public AjaxResult synItemOf (ItemInfo itemInfo) throws Exception;
    public AjaxResult synItemOfLotCode(ItemLotCodeInfo itemLotCodeInfo) throws Exception;
    public AjaxResult updateItemOf (ItemInfo itemInfo) throws Exception;
    public AjaxResult updateItemOfLotCode(ItemLotCodeInfo itemLotCodeInfo) throws Exception;
    public List<Customer> getU9CCustomerInfo();

}
