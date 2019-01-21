package com.loiter.order.enums;

import lombok.Getter;

/**
 * @description: ResultEnum
 * @author: ant-loiter
 * @date: 2019-01-18 11:38
 * 功能描述：API请求异常返回码的枚举类
 */
@Getter
public enum ResultEnum {
    PARAMER_ERROR(300, "参数错误"),
    CART_EMPTRY(301, "购物车为空");

    private Integer code;
    private String message;

    ResultEnum(Integer code , String message) {
        this.code = code;
        this.message = message;
    }
}
