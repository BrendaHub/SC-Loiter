package com.example.orderdemo.enums;

import lombok.Getter;

@Getter
public enum  OrderStatusEnum {
    New(0, "有效订单"),
    FINISHED(1, "处理完成"),
    CANCEL(2, "已取消");

    private Integer code;
    private String mesg;

    OrderStatusEnum(Integer code , String mesg) {
        this.code = code;
        this.mesg = mesg;
    }
}
