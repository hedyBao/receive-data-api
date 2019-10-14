package com.baobao.yddPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDiscountDetailApi {

    //优惠标识
    private int discountId;

    //优惠金额
    private BigDecimal discountPrice;

    //优惠名称
    private String discountName;

}
