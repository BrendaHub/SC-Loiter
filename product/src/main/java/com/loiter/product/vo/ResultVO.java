package com.loiter.product.vo;

import lombok.Data;

/**
 * @description: ResultVO
 * @author: ant-loiter
 * @date: 2019-01-17 14:59
 * 功能描述： 接口返回前端的最外层结果对象
 */
@Data
public class ResultVO<T> {

    // 请求结果编号
    private Integer Code ;

    // 请求结果描述
    private  String msg;

    // 请求结果内容
    private T data;
}
