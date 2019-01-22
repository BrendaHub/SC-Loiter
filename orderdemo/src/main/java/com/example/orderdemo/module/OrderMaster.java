package com.example.orderdemo.module;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OrderMaster {

    // 订单主键ID， 不是自增类型
    @Id
    public String orderId;
    // 订单购买者
    public String buyerName;
    // 订单购买 者联系电脑
    public String buyerPhone;
    // 订单购买者的地址
    public String buyerAddress;
    // 订单购买者的微信openid
    public String buyerOpenid;
    // 订单的数量
    public BigDecimal orderAmount;
    // 订单的状态
    public Integer orderStatus;
    // 订单的支付状态
    public Integer payStatus;
    // 订单创建时间
    public Date createTime;
    // 订单修改时间
    public Date updateTime;
}
