package com.loiter.order.controller;

import com.google.gson.Gson;
import com.loiter.order.VO.ResultVO;
import com.loiter.order.dto.OrderDto;
import com.loiter.order.enums.ResultEnum;
import com.loiter.order.exception.OrderException;
import com.loiter.order.form.OrderForm;
import com.loiter.order.service.OrderService;
import com.loiter.order.utils.OrderFormToOrderDto;
import com.loiter.order.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: OrderController
 * @author: ant-loiter
 * @date: 2019-01-18 11:26
 * 功能描述： 订单的业务处理的控制类
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * TODO 查询商品信息（调用商品服务）
     * TODO 计算总价
     * TODO 扣库存（调用商品服务）
     *  最后订单入库
     *  // 采用了表单验证处理逻辑
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create (@Valid OrderForm orderForm, BindingResult bindingResult) {
        // 参数处理逻辑
        if(bindingResult.hasErrors()) {
            log.error("【创建表单】参数不正确， orderFrom={}", orderForm);
//            throw new OrderException(300, "创建表单，参数不正确");// 这个写法不太好， 50分方案
            // 这样就可以获取到不同字段的不同错误信息， 与OrderForm表单对象上的注解关联
            throw new OrderException(ResultEnum.PARAMER_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        // 处理完参数后，需要保存订单， 需要把传进来的参数orderForm对象转换成OrderDto对象
        // 需要定义一个通用的对象转换工具类
        OrderDto orderDto = OrderFormToOrderDto.convert(orderForm);
        log.info("[INFO] " + orderDto.getOrderDetailList());
        // 再进行判断订单内容是否为空
        if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
            log.error("【创建订单】购物车为空");
            throw new OrderException(ResultEnum.CART_EMPTRY);
        }

        //判断完参数后，可以将订单插入数据库中
        OrderDto result = orderService.create(orderDto);

        Map<String, String> orderid = new HashMap<>();
        orderid.put("orderId", result.getOrderId());
        return ResultUtils.success(orderid);
    }
}
