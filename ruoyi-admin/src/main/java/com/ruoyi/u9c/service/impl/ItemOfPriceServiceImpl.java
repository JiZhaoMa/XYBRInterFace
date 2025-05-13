package com.ruoyi.u9c.service.impl;

import com.ruoyi.service.BPMService;
import com.ruoyi.service.U9CService;
import com.ruoyi.u9c.domain.ItemInfo;
import com.ruoyi.u9c.service.ItemOfPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemOfPriceServiceImpl implements ItemOfPriceService {
    @Autowired
    BPMService bpmService;
    @Autowired
    U9CService u9CService;
    @Override
    public void synItemOfPrice() {
        List<ItemInfo> itemInfoList = bpmService.getItemInfoList();
        List<String> suplierList = new ArrayList<>();
        suplierList.add("2101-055");  //天宝
        suplierList.add("2101-254");  //四联
        for(ItemInfo itemInfo : itemInfoList){
            if("已认证".equals(itemInfo.getItemStatus())){
                if("星源".equals(itemInfo.getPurchAttr())){
                    //自采物料单价：先根据 料号 供应商在厂商价目表里边匹配单价。再根据 料号 供应商在货源表里边匹配权值。最后根据单价和权值求加权平均单价
                    ItemInfo itemInfos = u9CService.selectPriceInfoOfXyPurch(itemInfo);
                    if(itemInfos != null){
                        bpmService.InsertItemPrice(itemInfos);
                        bpmService.updateItemPrice(itemInfos);
                    }
                }else if("外协".equals(itemInfo.getPurchAttr())){
                    //代采物料单价：根据 料号 供应商（代工厂）在厂商价目表里边匹配单价。备注：代采物料的单价不区分规格型号
                    for(String supplier : suplierList){
                        itemInfo.setSupplier(supplier);
                        ItemInfo itemInfos = u9CService.selectPriceInfoOfProxyPurch(itemInfo);
                        if(itemInfos != null){
                            bpmService.InsertItemPrice(itemInfos);
                            bpmService.updateItemPrice(itemInfos);
                        }
                    }
                }
            }else{
                //研发阶段的物料单价: 先根据 料号 规格型号 匹配采购订单的最新单价。然后求多个型号的单价平均值作为物料单价。
                ItemInfo itemInfos = u9CService.selectPriceInfoOfRdmStage(itemInfo);
                if(itemInfos != null){
                    bpmService.InsertItemPrice(itemInfos);
                    bpmService.updateItemPrice(itemInfos);
                }
            }
        }
        //更新料品的综合价格
        //bpmService.updateItemOverRallPrice();
    }
}
