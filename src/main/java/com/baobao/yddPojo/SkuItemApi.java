package com.baobao.yddPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuItemApi {

    //厂商单品ID
    private String vendorSkuId;

    //菜品名称
    private String spuName;

    //规格值
    private String specValue;

    //数量
    private int quantity;

    //单品为原单价，套餐为基础价格
    private BigDecimal skuOriginAmount;

    //备注信息
    private List<String> skuCommentList;

    //完整备注信息
    private List<VendorDishCommentValueApi> commentInfoList;

    //实付单价
    private BigDecimal skuRealAmount;

    //是否为套餐
    private Boolean setPackage;

    //是否为打包盒
    private Boolean setPackingBox;

    //套餐子菜品
    private List<PackageSkuApi> packageSkuList;

}
