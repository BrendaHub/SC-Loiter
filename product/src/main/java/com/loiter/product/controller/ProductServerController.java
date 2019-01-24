package com.loiter.product.controller;

import com.loiter.product.dto.CartDto;
import com.loiter.product.module.ProductInfo;
import com.loiter.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductServerController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/get")
    public String getProductInfo() {
        return "this.productinfo response!!";
    }

    // 对订单服务添加一个api方法
    // 当给参数添加了@RequestBody注解时， 就必须采用POST的调用方式
    @PostMapping("/listbyid")
    public List<ProductInfo> findProductList(@RequestBody  List<String> productList){
        return productService.findProductList(productList) ;
    }

    // 添加一个扣除商品库存的api接口
    @PostMapping("/deductproduct")
    public void deductProductStock(@RequestBody  List<CartDto> cartDtos) {
        productService.deductProduct(cartDtos);
    }
}
