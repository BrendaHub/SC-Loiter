package com.example.orderdemo.exception;

import com.example.orderdemo.enums.ResultEnum;

public class OrderException extends RuntimeException {

    private  Integer code;

    // 构造方法1
    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    // 构造方法2 通过ResultEnum对象构造异常类
    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMesg());
        this.code = resultEnum.getCode();
    }
}
