package com.loiter.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: CartDto
 * @author: ant-loiter
 * @date: 2019-01-24 14:29
 * 功能描述： 扣除商品库存的数据包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    // 商品ID
    private String productId;

    // 扣除商品的数量
    private Integer productQuantity;
}
