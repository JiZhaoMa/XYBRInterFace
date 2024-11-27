package com.ruoyi.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.domain.*;
import com.ruoyi.mapper.U9CMapper;
import com.ruoyi.service.U9CService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DataSource(value = DataSourceType.U9C)
@Service
public class U9CServiceImpl implements U9CService {
    @Autowired
    U9CMapper u9CMapper;

    @Override
    public List<Department> getU9CDeptByName(String name) {
        return u9CMapper.getU9CDeptByName(name);
    }
    @Override
    public Department getDepartCode(Department d) {
        return u9CMapper.getDepartCode(d);
    }

    @Override
    public List<User> getU9CUserInfo(User user) {
        return u9CMapper.getU9CUserInfo(user);
    }

    @Override
    public int updateU9CUserInfo(User user) {
        return u9CMapper.updateU9CUserInfo(user);
    }

    @Override
    public List<FixedFiled> getU9CFixedFiled() {
        return u9CMapper.getU9CFixedFiled();
    }

    @Override
    public List<Supplier> getU9CSupplier() {
        return u9CMapper.getU9CSupplier();
    }

    @Override
    public String getAssetCode(String assetCard) {
        return u9CMapper.getAssetCode(assetCard);
    }

    @Override
    public int updateOrderCode(String newOrderCode, String orderCode) {
        return u9CMapper.updateOrderCode(newOrderCode,orderCode);
    }

    @Override
    public int updateLotCode(String lotCode, String orderCode, String itemCode,int docLineNo,String deliveryDate) {
        return u9CMapper.updateLotCode(lotCode,orderCode,itemCode,docLineNo,deliveryDate);
    }

    @Override
    public ArriveQty selectArriveQty(ArriveQty arriveQty) {
        return u9CMapper.selectArriveQty(arriveQty);
    }
}
