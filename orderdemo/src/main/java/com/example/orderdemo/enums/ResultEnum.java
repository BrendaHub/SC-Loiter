package com.example.orderdemo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAMER_ERROR(0, "参数错误"),
    CART_EMPTY(1, "购物车为空"),
    CART_CONVERT_ERROR(2, "订单内容" +
            "转换错误");

    private Integer code;
    private String  mesg;

    ResultEnum(Integer code , String mesag) {
        this.code = code;
        this.mesg = mesag;
    }
}
