package com.example.orderdemo.from;

import lombok.Data;
import lombok.ToString;

import javax.naming.Name;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @description: OrderFrom
 * @author: ant-loiter
 * @date: 2019-01-22 17:03
 * 功能描述： 下订单的参数对象
 *
 */
@Data
@ToString
public class OrderFrom {
    /**
     * name: "张三"
     * phone: "18868822111"
     * address: "慕课网总部"
     * openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
     * items: [{
     *     productId: "1423113435324",
     *     productQuantity: 2 //购买数量
     * }]
     */
    // 参数表单，需要添加表单字段的较验
    @NotEmpty(message = "用户名不能为空")
    private String name;
    @NotEmpty(message = "联系电话信息不能为空")
    private String phone;
    @NotEmpty(message = "地址信息不能为空")
    private String address;
    @NotEmpty(message = "微信的身份ID不能为空")
    private  String openid;
    @NotEmpty(message = "订单必要数据不能为空")
    private String items;
}
