package com.baobao.yddPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDishCommentValueApi {

    //备注值ID
    private String commentValueId;

    //备注值
    private String commentValue;

    //加价，默认为0
    private BigDecimal addPrice;

}
