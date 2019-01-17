package com.loiter.product.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @description: ProductStatusEnum
 * @author: ant-loiter
 * @date: 2019-01-17 14:38
 * 功能描述：商品状态枚举类
 * 注：  这里有个注坑， 在用lombok里不在添加@Data注解， 因为枚举是不能设计Setter类方法的。 这是一个标准 的枚举类
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
