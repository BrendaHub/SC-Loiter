package com.example.orderdemo.service.impl;

import com.example.orderdemo.Dao.OrderMasterRepository;
import com.example.orderdemo.dto.OrderDto;
import com.example.orderdemo.enums.OrderStatusEnum;
import com.example.orderdemo.enums.PayStatusEnum;
import com.example.orderdemo.module.OrderMaster;
import com.example.orderdemo.service.OrderService;
import com.example.orderdemo.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    // 业务就是保存订单对象的数据
    @Override
    public OrderDto create(OrderDto orderDto) {
        // TODO 查询商品信息（调用商品服务）
        // TODO 计算总价
        // TODO 扣库存（调用商品服务）
        // 最后订单入库
        // orderDto 不能直接入库， 没有对应的表模型
        OrderMaster orderMaster = new OrderMaster();
        // 先把转入的orderDto对象转换到orderMaster中

        // 需要生成一个订单的唯一主键； 写一个专用的工具类KeyUtils
        orderDto.setOrderId(KeyUtils.getKey());
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.New.getCode());
        orderMaster.setPayStatus(PayStatusEnum.INIT.getCode());
        List list = orderDto.getOrderDetailList().stream().map(item -> item.getProductQuantity()).collect(Collectors.toList());
        log.info(list.get(0)+">>>>>");
        orderMaster.setOrderAmount(new BigDecimal(8));

        orderMaster = orderMasterRepository.save(orderMaster);

        BeanUtils.copyProperties(orderMaster, orderDto);

        return orderDto;
    }
}
