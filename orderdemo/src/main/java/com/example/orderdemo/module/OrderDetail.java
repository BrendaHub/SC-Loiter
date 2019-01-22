package com.example.orderdemo.module;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class OrderDetail {

    @Id
    public String edetailId;
    public String orderId;
    public String productId;
    public String productName;
    public BigDecimal productPrice;
    public Integer productQuantity;
    public String productIcon;
    public Date createTime;
    public Date updateTime;
}
