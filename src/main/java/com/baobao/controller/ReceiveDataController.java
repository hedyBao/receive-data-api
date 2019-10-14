package com.baobao.controller;
import com.baobao.YddHashMapRepository.YddOrdersMap;
import com.baobao.bo.BasicSimpleResponseModel;
import com.baobao.bo.BasicResponseModel;
import com.baobao.yddPojo.DiancanOrderPushRemoteRequest;
import com.baobao.yddPojo.PackageSkuApi;
import com.baobao.yddPojo.SkuItemApi;
import com.baobao.yddPojo.VendorDishCommentValueApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ReceiveDataController {
    @Autowired
    private YddOrdersMap yddOrdersMap;

    @RequestMapping("/orderPreCheck")
    @ResponseBody
    @Description("下单校验")
    public BasicResponseModel orderPreCheck(){
        BasicResponseModel rp = new BasicResponseModel();
        if(!rp.isSuccess()){
            throw new RuntimeException("校验失败");
        }
        return rp;
    }



    @RequestMapping (value ="/yddOrderRequest",method = RequestMethod.POST)
    @Description("订单推送")
    @ResponseBody
    public BasicSimpleResponseModel yddOrderRequest(DiancanOrderPushRemoteRequest r){
        if(r==null){
            throw new RuntimeException("订单数据为空");
        }
// r里面包含的参数比较多：是否分为两步？先把里面包含的具体的list分步接收，再把整体的参数依次接收
//        r 里面包含List<SkuItemApi> skuItems；
//        SkuItemApi里面包含List<PackageSkuApi> packageSkuList；
//        PackageSkuApi里面包含List<VendorDishCommentValueApi> commentInfoList
//        VendorDishCommentValueApi包含了commentValueId、commentValue、addPrice；
//所以接收的时候也一步一步来：
//         1 先从上级get list ; new 实体，接受 list里面get出来的属性，每一级都这样操作
        List<VendorDishCommentValueApi> vendorDishCommentValueApis = new ArrayList<>();
        List<PackageSkuApi> packageSkuApis = new ArrayList<>();
        List<SkuItemApi> skuItemApis = new ArrayList<>();

        SkuItemApi skuItemApi = new SkuItemApi();
        skuItemApis= r.getSkuItems();
        if(skuItemApi!=null){
            for(SkuItemApi s : skuItemApis){
                skuItemApi.setPackageSkuList(s.getPackageSkuList());
            }
        }
        skuItemApis.add(skuItemApi);

        PackageSkuApi packageSkuApi = new PackageSkuApi();
        packageSkuApis = skuItemApi.getPackageSkuList();
        if(packageSkuApis!=null){
            for(PackageSkuApi packageSkuApi1: packageSkuApis){
                packageSkuApi.setCommentInfoList(packageSkuApi1.getCommentInfoList());
            }
        }
        packageSkuApis.add(packageSkuApi);


        VendorDishCommentValueApi v= new VendorDishCommentValueApi();
        vendorDishCommentValueApis=packageSkuApi.getCommentInfoList();
        if(vendorDishCommentValueApis!=null){
            for(VendorDishCommentValueApi v1:vendorDishCommentValueApis){
                v.setCommentValueId(v1.getCommentValueId());
                v.setCommentValue(v1.getCommentValue());
                v.setAddPrice(v1.getAddPrice());

            }
        }
        vendorDishCommentValueApis.add(v);




        yddOrdersMap.saveYddOrder(r.getDpOrderId(), r);
        yddOrdersMap.saveYddOrderParams("dpOrderId",r.getDpOrderId());
        yddOrdersMap.saveYddOrderParams("dpShopId",r.getDpShopId());
        yddOrdersMap.saveYddOrderParams("dpShopUUid",r.getDpShopUUid());
        yddOrdersMap.saveYddOrderParams("vendorShopId",r.getVendorShopId());
        yddOrdersMap.saveYddOrderParams("originAmount",r.getOriginAmount());
        yddOrdersMap.saveYddOrderParams("shopDiscountAmount",r.getShopDiscountAmount());
        yddOrdersMap.saveYddOrderParams("platformDiscountAmount",r.getPlatformDiscountAmount());
        yddOrdersMap.saveYddOrderParams("discountDetailList",r.getDiscountDetailList());
        yddOrdersMap.saveYddOrderParams("realPayAmount",r.getRealPayAmount());
        yddOrdersMap.saveYddOrderParams("realAmount",r.getRealAmount());
        yddOrdersMap.saveYddOrderParams("status",r.getStatus());
        yddOrdersMap.saveYddOrderParams("tableNumber",r.getTableNumber());
        yddOrdersMap.saveYddOrderParams("orderType",r.getOrderType());
        yddOrdersMap.saveYddOrderParams("isTakeAway",r.getIsTakeAway());
        yddOrdersMap.saveYddOrderParams("phone",r.getPhone());
        yddOrdersMap.saveYddOrderParams("barCode",r.getBarCode());
        yddOrdersMap.saveYddOrderParams("createTime",r.getCreateTime());
        yddOrdersMap.saveYddOrderParams("fetchTime",r.getFetchTime());
        yddOrdersMap.saveYddOrderParams("deadLine",r.getDeadLine());
        yddOrdersMap.saveYddOrderParams("num",r.getNum());
        yddOrdersMap.saveYddOrderParams("payChannel",r.getPayChannel());
        yddOrdersMap.saveYddOrderParams("orderComment",r.getOrderComment());
        yddOrdersMap.saveYddOrderParams("skuItems",r.getDiscountDetailList());
        return new BasicSimpleResponseModel(200,r.getDpOrderId());
    }






}
