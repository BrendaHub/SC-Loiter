package com.loiter.product.enums;


import lombok.Getter;

/**
 * @author ant-loiter
 */

@Getter
public enum  ProductNumberEnum {
    PRODUCT_EMPTRY(0, "商品数量为零"),
    PRODUCT_NOT_MORE(1, "商品不扣当前订单");

    private Integer code;
    private String message;

    ProductNumberEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
