package com.baobao.syncEntity;



import com.baobao.yddPojo.PackageSkuApi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.util.List;


@EntityScan
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SyncOrderSkuItemBO {
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

    //实付单价
    private BigDecimal skuRealAmount;

    //是否为套餐
    private Boolean setPackage;

    //是否为打包盒
    private Boolean setPackingBox;

    //套餐子菜品
    private List<PackageSkuApi> packageSkuList;



}
