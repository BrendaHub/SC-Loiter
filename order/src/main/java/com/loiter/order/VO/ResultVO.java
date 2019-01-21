package com.loiter.order.VO;

import lombok.Data;

/**
 * @description: ResultVO
 * @author: ant-loiter
 * @date: 2019-01-18 14:25
 * 功能描述： 接口请求响应返回对象
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private  String msg;

    private T t;
}
