package com.example.orderdemo.controller;

import com.example.orderdemo.VO.ResultVO;
import com.example.orderdemo.dto.OrderDto;
import com.example.orderdemo.enums.ResultEnum;
import com.example.orderdemo.exception.OrderException;
import com.example.orderdemo.from.OrderFrom;
import com.example.orderdemo.service.OrderService;
import com.example.orderdemo.utils.OrderFromToOrderDtoConvert;
import com.example.orderdemo.utils.ResultUtils;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;


    public String index() {
        return new Gson().toJson("success");
    }

    @RequestMapping("/list")
    public String test(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        return new Gson().toJson(list);
    }


    /**
     * TODO 查询商品信息（调用商品服务）
     * TODO 计算总价
     * TODO 扣库存（调用商品服务）
     *  最后订单入库
     *  // 采用了表单验证处理逻辑
     *  添加了表单的较验， 结果会在BindingResult对象中
     */
    @RequestMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderFrom orderFrom, BindingResult bindingResult) {
        // 需要验证表单的有效性
        if(bindingResult.hasErrors()) { // 表单字段验证有错误
            log.error("【创建订单】 参数错误： {}", orderFrom);
            // 这里还需要主动抛出一个异常，自定义
            throw new OrderException(ResultEnum.PARAMER_ERROR);
        }
        // 需要将OrderFrom 转换成 OrderDto 对象
        OrderDto orderDto = OrderFromToOrderDtoConvert.convert(orderFrom);
        // 内容转换后， 还需要判断一下订单内容是否为空
        if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
            log.error("【创建订单】 订单内容为空，不能创建订单");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDto result =  orderService.create(orderDto);

        // 最后就是构建一个返回对象

        Map<String, String > map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultUtils.successful(map);

    }
}
