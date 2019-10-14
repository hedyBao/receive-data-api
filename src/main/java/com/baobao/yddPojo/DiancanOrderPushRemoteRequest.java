package com.baobao.yddPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiancanOrderPushRemoteRequest {

    //美团订单编号
    private String dpOrderId;

    //点评shopId(该字段已废弃)
    private String dpShopId;

    //点评门店UUid
    private String dpShopUUid;

    //厂商商户ID
    private String vendorShopId;

    //原价（订单所有菜品原价+餐位费）
    private BigDecimal originAmount;

    //商户优惠价格
    private BigDecimal shopDiscountAmount;

    //平台优惠价格
    private BigDecimal platformDiscountAmount;

    //优惠金额明细
    private List<OrderDiscountDetailApi> discountDetailList;

    //用户实付
    private BigDecimal realPayAmount;

    //商户实收
    private BigDecimal realAmount;

    //状态, 0: 未支付, 1: 已支付, 2: 已接单, 3: 接单失败, 4: 已核销, 5: 已退款
    private int status;

    //桌号
    private String tableNumber;

    //订单类型, 0: 店内点餐, 1: 预约自提
    private int orderType;

    //就餐方式, 1: 外带, 0: 堂食
    private int isTakeAway;

    //用户下单手机号
    private String phone;

    //取餐号
    private String barCode;

    //下单时间 (YYYY-MM-dd hh:mm:ss格式)
    private String createTime;

    //店内点餐为空 预约自提时间(YYYY-MM-dd hh:mm:ss格式)
    private String fetchTime;

    //超时时间 (YYYY-MM-dd hh:mm:ss格式)
    private String deadLine;

    //就餐人数
    private int num;

    //支付方式, 1: 支付宝, 2: 微信支付, 3: 美团支付
    private int payChannel;

    //整单备注
    private List<String> orderComment;

    //购买的sku
    private List<SkuItemApi> skuItems;
}
