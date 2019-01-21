package com.loiter.order.module;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: OrderMaster
 * @author: ant-loiter
 * @date: 2019-01-17 17:59
 * 功能描述：订单主表实体
 */
@Data
@Entity
public class OrderMaster implements Serializable {

    // 订单主表的主键
    @Id
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

    // 记录创建时间
    private Date createTime;

    // 记录修改时间
    private Date updateTime;
}
