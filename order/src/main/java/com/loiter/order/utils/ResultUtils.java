package com.loiter.order.utils;

import com.loiter.order.VO.ResultVO;

/**
 * @description: ResultUtils
 * @author: ant-loiter
 * @date: 2019-01-18 14:31
 * 功能描述： 处理各种请求返回处理结果
 */
public class ResultUtils {

    // 添加处理成功的响应方法
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setT(object);
        return resultVO;
    }
}
