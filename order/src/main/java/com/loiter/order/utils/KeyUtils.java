package com.loiter.order.utils;

import java.util.Random;

/**
 * @description: KeyUtils
 * @author: ant-loiter
 * @date: 2019-01-17 19:10
 * 功能描述： 生成唯 一key的工具类
 */
public class KeyUtils {

    public static synchronized String getUniqueKey() {
        // 生成一个8位的随进数
        Random random = new Random();
        Integer ranNum = random.nextInt(90000000)  + 10000000;

        // 获取当前的时间截
        Long currentTime = System.currentTimeMillis();

        return currentTime + String.valueOf(ranNum);
    }
}
