package com.baobao.syncEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//存关键数据，作为订单主表存在数据库里
public class OrderBo {
    //主键
    private String ouid;
    //美团订单编号
    private String dpOrderId;
    //厂商商户ID
    private String vendorShopId;
    //支付方式, 1: 支付宝, 2: 微信支付, 3: 美团支付
    private int payChannel;
}
