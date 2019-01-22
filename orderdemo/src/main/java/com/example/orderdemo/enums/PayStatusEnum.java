package com.example.orderdemo.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    INIT(0,"未支付"),
    PAYED(1, "成功支付"),
    CANCEL(2, "无效支付");

    private  Integer code;
    private String mesage;

    PayStatusEnum(Integer code , String mesage) {
        this.code = code;
        this.mesage = mesage;
    }
}
