package com.loiter.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartDto {

    // 商品ID
    private String productId;

    // 扣除商品的数量
    private Integer productQuantity;
}
