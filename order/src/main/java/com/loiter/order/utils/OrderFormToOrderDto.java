package com.loiter.order.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loiter.order.dto.OrderDto;
import com.loiter.order.enums.OrderStatusEnum;
import com.loiter.order.enums.ResultEnum;
import com.loiter.order.exception.OrderException;
import com.loiter.order.form.OrderForm;
import com.loiter.order.module.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: OrderFormToOrderDto
 * @author: ant-loiter
 * @date: 2019-01-18 11:45
 * 功能描述： 对象相互转换的工具类
 */
@Slf4j // 引入slf4j写日志的类
public class OrderFormToOrderDto {

    public static OrderDto convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        // 接下要需要把orderForm表单里面的一个字符串对象转换成OrderDto里面的List属性值
        // 这里用到一个GSON工具类，需要pom里面引入Gson对象
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            // 这个是通过Gson工具将实现bean之间的转换
            orderDetailList =  gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
            if(!CollectionUtils.isEmpty(orderDetailList)) {
                for(OrderDetail od : orderDetailList) {
                    log.info(od.getDetailId());
                    log.info(od.getProductId());
                    log.info(od.getProductQuantity() + "");
                }
            }
        }catch (Exception e){
            // 这里需要添加日志
            log.error("【JSON转换】错误，string={}",orderForm.getItems());
            // 抛出异常
            //throw new OrderException(ResultEnum.PARAMER_ERROR.getCode(), ResultEnum.PARAMER_ERROR.getMessage());
            throw new OrderException(ResultEnum.PARAMER_ERROR); // 这样书写比上面的书写方式更加简洁
        }
        // 将参数里的items内容 转换成对象list内容
        orderDto.setOrderDetailList(orderDetailList);

        return orderDto;
    }
}
