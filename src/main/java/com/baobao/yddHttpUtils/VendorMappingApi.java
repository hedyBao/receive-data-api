package com.baobao.yddHttpUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorMappingApi {

    //点评ShopId
    private int dpShopId;

    //厂商shopId
    private String vendorShopId;

    //厂商商户名
    private String vendorShopName;

    //点评门店名称
    private String dpShopName;

    //业务类型, 10: 点餐, 20: 排队, 40: 秒付, 50: 支核一体, 101: 团购, 103: 闪惠
    private List<Integer> businessTypeList;

}
