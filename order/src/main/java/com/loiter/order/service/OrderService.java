package com.loiter.order.service;

import com.loiter.order.dto.OrderDto;

/**
 * @description: OrderService
 * @author: ant-loiter
 * @date: 2019-01-17 19:02
 * 功能描述： 订单业务接口
 */
public interface OrderService {

    // 创建订单
    OrderDto create(OrderDto orderDto);
}
