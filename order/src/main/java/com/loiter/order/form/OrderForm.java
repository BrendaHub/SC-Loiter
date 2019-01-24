package com.loiter.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @description: OrderForm
 * @author: ant-loiter
 * @date: 2019-01-17 19:23
 * 功能描述：在线下单的请求参数封装，
 * 技术栈，用到了一个表单实体的检验处理类， 被封装在hibernate包里面
 */
@Data
public class OrderForm {

    @NotEmpty(message = " 姓名必填")
    private  String name;

    @NotEmpty(message = "电话号码不能为空")
    private String phone;

    @NotEmpty(message = "地址不能为空")
    private String address;

    @NotEmpty(message = "下订单的用户openid不能为空")
    private String openid;

    @NotEmpty(message = "订单内容不能为空")
    private String items;
}
