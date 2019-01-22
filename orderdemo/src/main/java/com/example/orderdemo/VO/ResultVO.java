package com.example.orderdemo.VO;

import lombok.Data;

// 请求响应的对象
@Data
public class ResultVO<T> {

    /**
     * {
     *   "code": 0,
     *   "msg": "成功",
     *   "data": {
     *       "orderId": "147283992738221"
     *   }
     * }
     */

    private Integer code;

    private String msg;

    // 这个对象，定义成一个范型类
    private  T t;

}
