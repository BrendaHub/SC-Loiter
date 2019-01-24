package com.loiter.order.controller;

import com.loiter.order.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/remote")
public class ProductClientController {

//    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/info")
    public String getProduct(){
        //1、第一种方式， 直接采用resttemplate对象调用服务
//        RestTemplate restTemplate = new RestTemplate();
//        String response =  restTemplate.getForObject("http://localhost:8080/product/get", String.class);
//        log.info("repsonse = {}", response);

        // 2、 第二种方式， 采用springcloud里提供的loadBanldclient对象，来获取eureka里面的服务资源
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s/product/get", serviceInstance.getHost(), serviceInstance.getPort()) ;
        log.info("url = {}", url);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response = {}", response);

        // 3、 第三种方式，使用@localBanld注解
//        String response = restTemplateConfig.getRestTemplateConfig().getForObject("http://PRODUCT/product/get", String.class);
//        String response = template.getForObject("http://PRODUCT/product/get", String.class);
//        restTemplateConfig.

//        String response = restTemplate.getForObject("http://PRODUCT/product/get", String.class);
//
//        log.info("response = {}", response);
        return response;
    }
}
