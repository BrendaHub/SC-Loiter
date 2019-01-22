package com.example.orderdemo.service;

import com.example.orderdemo.dto.OrderDto;

/**
 * @description: OrderService
 * @author: ant-loiter
 * @date: 2019-01-22 16:32
 * 功能描述： 创建订单的业务处理类
 */
public interface OrderService {

    // 业务就是创建一个有效的订单， 参数，这里需要把输入的参数构造成一个对象
    OrderDto create(OrderDto orderDto);
}
