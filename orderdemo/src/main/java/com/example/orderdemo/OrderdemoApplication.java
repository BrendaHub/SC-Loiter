package com.example.orderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderdemoApplication.class, args);
    }

}

