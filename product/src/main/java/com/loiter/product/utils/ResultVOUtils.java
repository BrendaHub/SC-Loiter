package com.loiter.product.utils;

import com.loiter.product.vo.ResultVO;

/**
 * @description: ResultVOUtils
 * @author: ant-loiter
 * @date: 2019-01-17 16:16
 * 功能描述： 返回结果的处理类
 */
public class ResultVOUtils {

    public static ResultVO success(Object obj ){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(obj);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
