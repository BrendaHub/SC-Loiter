package com.example.orderdemo.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class KeyUtils {

    // 加同步锁
    public static synchronized String getKey() {

        // 时间截 + 随机数
        Random random = new Random();
        // 产生一个6位的随时数
        Integer randInt = random.nextInt(9000000) + 1000000;

         log.info("【工具类】生成的随机数： {}", randInt );

         return System.currentTimeMillis() + String.valueOf(randInt) ;

    }
}
