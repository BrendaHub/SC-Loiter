package com.loiter.order.service.impl;

import com.loiter.order.dto.OrderDto;
import com.loiter.order.enums.OrderStatusEnum;
import com.loiter.order.enums.PayStatusEnum;
import com.loiter.order.module.OrderMaster;
import com.loiter.order.repository.OrderDetailRepository;
import com.loiter.order.repository.OrderMasterRepository;
import com.loiter.order.service.OrderService;
import com.loiter.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDto create(OrderDto orderDto) {
        // TODO 查询商品信息（调用商品服务）
        // TODO 计算总价
        // TODO 扣库存（调用商品服务）
        // 最后订单入库
        OrderMaster orderMaster = new OrderMaster();
        // 先生成一个唯一的订单ID， 在同一个订单的不同实体里的订单id要唯一
        orderDto.setOrderId(KeyUtils.getUniqueKey());
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster om = orderMasterRepository.save(orderMaster);

        BeanUtils.copyProperties(orderMaster, orderDto);

        return orderDto;
    }
}
