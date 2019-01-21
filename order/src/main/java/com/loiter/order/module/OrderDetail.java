package com.loiter.order.module;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: OrderDetail
 * @author: ant-loiter
 * @date: 2019-01-17 17:53
 * 功能描述： 订单详情实体
 */
@Data
@Entity
public class OrderDetail implements Serializable {

    // 订单详情id
    @Id
    private String detailId;

    // 订单Id
    private String orderId;

    // 订单中商品ID
    private  String productId;

    // 商品名称
    private  String productName;

    // 商品价格
    private BigDecimal productPrice;

    // 订单中商品数量
    private  Integer productQuantity;

    // 商品图标
    private String productIcon;

    // 记录创建时间
    private Date createTime;

    // 记录修改时间
    private Date updateTime;
}
