package com.example.orderdemo.utils;

import com.example.orderdemo.VO.ResultVO;

import java.util.Map;

public class ResultUtils {

    public static ResultVO successful(Map<String, String> map) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setT(map);
        return resultVO;
    }
}
