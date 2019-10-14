package com.baobao.yddHttpUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopMappingQueryRequest {

    private List<Integer> dpShopIdList;

    private List<String> vendorShopIdList;

    private Integer businessType;

}
