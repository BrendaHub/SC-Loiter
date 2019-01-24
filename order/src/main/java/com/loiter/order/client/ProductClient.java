package com.loiter.order.client;

import com.loiter.order.dto.CartDto;
import com.loiter.order.module.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description: ProductClient
 * @author: ant-loiter
 * @date: 2019-01-23 17:02
 * 功能描述： 这个是采用了Feign组件调用微服务资源的接口
 */
// 配置了资源名称， 即在Eureka注册的资源名称
@FeignClient(name = "product")
public interface ProductClient {

    // 接口调用RestFull的资源名称
    @GetMapping("/product/get")
    String getProducts();

    // 根据商品id获取所有商品信息
    @PostMapping("/product/listbyid")
    List<ProductInfo> findProductListByID(@RequestBody List<String> productList);

    // 添加一个调用商品服务里面扣除商品库存的服务
    @PostMapping("/product/deductproduct")
    void deductProductStock(@RequestBody List<CartDto> cartDtos);
}
