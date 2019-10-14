package com.baobao.yddPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageSkuApi {

    //厂商子菜品ID
    private String vendorSkuId;

    //规格值
    private String specValue;

    //子菜品数量
    private int quantity;

    //子菜品完整备注信息
    private List<VendorDishCommentValueApi> commentInfoList;
}
