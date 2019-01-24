package com.loiter.order.module;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: ProductInfo
 * @author: ant-loiter
 * @date: 2019-01-17 11:32
 * 功能描述： 商品信息实体对象
 */
@Entity
@Data
public class ProductInfo implements Serializable {

    // 商品id
    @Id
    private String productId;

    // 商品名称
    private String productName;

    // 商品价格
    private BigDecimal productPrice;

    // 商品库存
    private Integer productStock;

    // 商品描述
    private  String productDescription;

    // 商品小图标
    private String productIcon;

    // 商品状态 0：正常； 1：下架
    private Integer productStatus;

    // 商品对应的类目编号
    private Integer categoryType;

    // 记录创建时间
    private Date createTime;

    // 记录修改时间
    private Date updateTime;

}
