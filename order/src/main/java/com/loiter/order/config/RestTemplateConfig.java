package com.loiter.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @description: RestTemplateConfig
 * @author: ant-loiter
 * @date: 2019-01-23 17:02
 * 功能描述： 这个是RestTemplate的方式调用服务资源， 与 ProductClientController的配合使用；
 */
@Component
public class RestTemplateConfig {

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemp() {
        return new RestTemplate();
    }
}
