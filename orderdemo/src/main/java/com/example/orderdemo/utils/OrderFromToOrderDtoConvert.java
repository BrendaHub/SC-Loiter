package com.example.orderdemo.utils;

import com.example.orderdemo.dto.OrderDto;
import com.example.orderdemo.enums.ResultEnum;
import com.example.orderdemo.exception.OrderException;
import com.example.orderdemo.from.OrderFrom;
import com.example.orderdemo.module.OrderDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OrderFromToOrderDtoConvert {

    public static OrderDto convert(OrderFrom orderFrom) {

        /**
         * name: "张三"
         * phone: "18868822111"
         * address: "慕课网总部"
         * openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
         * items: [{
         *     productId: "1423113435324",
         *     productQuantity: 2 //购买数量
         * }]
         */
        OrderDto orderDto  = new OrderDto();

        orderDto.setBuyerName(orderFrom.getName());
        orderDto.setBuyerPhone(orderFrom.getPhone());
        orderDto.setBuyerAddress(orderFrom.getAddress());
        orderDto.setBuyerOpenid(orderFrom.getOpenid());
        String items = orderFrom.getItems();
        // 需要将一个json数组对象转换成list
        List<OrderDetail> list = null;
        try{
            list = new Gson().fromJson(items, new TypeToken<List<OrderDetail>>() {
            }.getType());

            for(OrderDetail orderDetail : list) {
                log.info("od>>" + orderDetail.productQuantity);
                log.info("od>> " + orderDetail.getOrderId());
            }
        }catch (Exception e) {
            log.info("【创建订单】转换订单数量内容出错");
            throw new OrderException(ResultEnum.CART_CONVERT_ERROR);
        }
        orderDto.setOrderDetailList(list);
        return orderDto;
    }
}
