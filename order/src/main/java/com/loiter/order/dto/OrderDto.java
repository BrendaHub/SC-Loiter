package com.loiter.order.dto;

import com.loiter.order.module.OrderDetail;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

/**
 * @description: OrderDto
 * @author: ant-loiter
 * @date: 2019-01-17 18:57
 * 功能描述： orderMaster 与 orderdetail 的包装类
 */
@Data
public class OrderDto {


    // 订单主表的主键
    private String orderId;

    // 买家名称
    private String buyerName;

    // 买 家电话
    private String buyerPhone;

    private  String buyerAddress;

    private String buyerOpenid;

    // 订单总金额
    private BigDecimal orderAmount;

    // 订单的状态 ， 默认为新下单状态 ， 0
    private Integer orderStatus;

    // 订单支付状态 ， 默认为未支付的状态 ； 0
    private  Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
