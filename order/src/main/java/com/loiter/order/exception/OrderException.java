package com.loiter.order.exception;

import com.loiter.order.enums.ResultEnum;

/**
 * @description: OrderException
 * @author: ant-loiter
 * @date: 2019-01-18 11:31
 * 功能描述： 自定义的订单处理异常类
 */
public class OrderException extends RuntimeException {

    private Integer code;

    // 构造方法1
    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    // 构造方法2 通过ResultEnum对象构造异常类
    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
