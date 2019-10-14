package com.baobao.controller;


import com.baobao.YddHashMapRepository.YddOrdersMap;
import com.baobao.syncEntity.SyncOrderBO;
import com.baobao.syncEntity.SyncOrderSkuItemBO;
import com.baobao.syncEntity.SyncPromBO;
import com.baobao.yddPojo.*;

import java.util.ArrayList;
import java.util.List;


public class YddToSync {

    private YddOrdersMap yddOrdersMap;

    public SyncOrderBO convertYddToSync(DiancanOrderPushRemoteRequest r, SyncOrderBO b){
//        判断是映射关系的店铺,则把订单转换为SyncOrder
        if(yddOrdersMap.isMapping(r.getDpShopId())){
//最近的一个困惑：如何把r里list类型的数据转换给b里list类型的数据，下面是自己探索的思路，还未实践：
//new一个接收的实体及实体的list及r的list，将r的值set给list，遍历r的List，r里get的参数set给实体的每一个字段，
//再将实体整个添加到list里，将list通过set赋值给b
//通过以上的方法，b的实体也有值，如果此时落库，也可，list里面也有值了。
//只是显得略繁琐？
//忘记先判断一下list不为空，可见，目前对于特殊情况的思考不够充分。
//目前的想法是先将零散的几个数存进去，然后将其他的list形式的以list的格式一次存进去。
            b.setDpOrderId(r.getDpOrderId());
            b.setVendorShopId(r.getVendorShopId());
            b.setPayChannel(r.getPayChannel());
            createSyncPromBOS(r,b);
            createSyncOrderSkuItemBOS(r,b);
        }
        return b;
    }
    public void createSyncPromBOS(DiancanOrderPushRemoteRequest r,SyncOrderBO s){
        List<OrderDiscountDetailApi> discountlist = r.getDiscountDetailList();
        if(discountlist!=null){
            SyncPromBO prom = new SyncPromBO();
            for(OrderDiscountDetailApi i : discountlist){
                prom.setPromId(i.getDiscountId());
                prom.setPromName(i.getDiscountName());
                prom.setPromPrice(i.getDiscountPrice());
            }
            List<SyncPromBO> promsList = new ArrayList<>();
            promsList.add(prom);
            s.setSyncProms(promsList);
        }
    }

    public void createSyncOrderSkuItemBOS(DiancanOrderPushRemoteRequest r,SyncOrderBO b){
        List<SyncOrderSkuItemBO> syncOrderSkuItemBOS = new ArrayList<>();
        SyncOrderSkuItemBO syncOrderSkuItemBO = new SyncOrderSkuItemBO();
        List<SkuItemApi> skuItemApiList=r.getSkuItems();
        if(skuItemApiList!=null){
            for(SkuItemApi i:skuItemApiList){
                   syncOrderSkuItemBO.setVendorSkuId(i.getVendorSkuId());
                   syncOrderSkuItemBO.setSpuName(i.getSpecValue());
                   syncOrderSkuItemBO.setQuantity(i.getQuantity());
                   syncOrderSkuItemBO.setSetPackage(i.getSetPackage());
                   syncOrderSkuItemBO.setSetPackingBox(i.getSetPackingBox());
                   syncOrderSkuItemBO.setSkuOriginAmount(i.getSkuOriginAmount());
                   syncOrderSkuItemBO.setSkuOriginAmount(i.getSkuRealAmount());
            }
            syncOrderSkuItemBOS.add(syncOrderSkuItemBO);

        }
       b.setOrderSkuItems(syncOrderSkuItemBOS);
    }

}
