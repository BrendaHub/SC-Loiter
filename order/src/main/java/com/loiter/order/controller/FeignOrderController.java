package com.loiter.order.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loiter.order.client.ProductClient;
import com.loiter.order.dto.CartDto;
import com.loiter.order.module.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: FeignOrderController
 * @author: ant-loiter
 * @date: 2019-01-23 17:13
 * 功能描述： 通过Feign调用服务资源。这里定义了可以调用的api接口
 */
@RestController
@RequestMapping("/client/product")
@Slf4j
public class FeignOrderController {

    @Autowired
    private ProductClient productClient;

    @RequestMapping("/info")
    public String getProduct() {

        String response = productClient.getProducts();
        log.info("response = {}", response);
        return response;
    }

    @PostMapping("/listbyid")
    public String getProductInfoList(@RequestBody List<String> productidlist) {

        List<ProductInfo> list = productClient.findProductListByID(productidlist);
        log.info("product info list = {}", new Gson().toJson(list));
        return "ok";
    }

    // 调用扣除商品库存的服务
    @PostMapping("/deductproductstock")
    public String deductProductStock(@RequestBody String cartliss) {
        List<CartDto> cartDtos = new ArrayList<>();
        if (cartliss != null && cartliss.length() > 0 ) {
            cartDtos = new Gson().fromJson(cartliss, new TypeToken<List<CartDto>>(){}.getType());
        }
        productClient.deductProductStock(cartDtos);
        return "successfull";
    }
}
