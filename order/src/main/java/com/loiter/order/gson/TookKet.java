package com.loiter.order.gson;

import com.google.gson.Gson;
import com.loiter.order.utils.KeyUtils;
import com.sun.org.apache.bcel.internal.generic.INEG;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description: TookKet
 * @author: ant-loiter
 * @date: 2019-01-21 16:44
 * 功能描述： Gson常用工具的学习
 */
@Slf4j
public class TookKet {

    public static void main(String[] args) {
        // 将bean转换成json字符串
        Emplooy emplooy = new Emplooy(KeyUtils.getUniqueKey(), "loiter",30, new Date(), BigDecimal.valueOf(3.04));
        // 这个是将一个实例对象转换成json字符串
        log.info(new Gson().toJson(emplooy));

        // 将json字符串转换成对象， 这样需要二个参数， 一个字符串内容，第二个是目标类型对象
        String _json = "{\"ID\":\"154806160266435272194\",\"name\":\"loiter\",\"age\":30,\"createTime\":\"Jan 21, 2019 5:06:42 PM\",\"count\":3.04}";
        Emplooy emplooy1 = new Gson().fromJson(_json, Emplooy.class);
        log.info(emplooy1.toString());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Emplooy{
    private String ID;
    private String name;
    private Integer age;
    private Date createTime;
    private BigDecimal count;

}
