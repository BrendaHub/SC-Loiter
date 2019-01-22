package com.loiter.order.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loiter.order.utils.KeyUtils;
import com.oracle.tools.packager.Log;
import com.sun.org.apache.bcel.internal.generic.INEG;
import com.sun.org.apache.xerces.internal.xs.PSVIProvider;
import jdk.nashorn.internal.parser.TokenType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import sun.security.jgss.GSSCaller;

import javax.naming.Name;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @description: TookKet
 * @author: ant-loiter
 * @date: 2019-01-21 16:44
 * 功能描述： Gson常用工具的学习  测试包，里面的类都是用来测试
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

        /// 将一个json串转换成List集合对象，有二种转换主法，
        String _json_arr = "[{\"name\":\"loister\",\"age\":\"67\"}]";
        // 1、 先将转换成数组， 再转换成集合list
        Emplooy[] _str_arr = new Gson().fromJson(_json_arr, Emplooy[].class);
        List<Emplooy> list = Arrays.asList(_str_arr);
        // 2、第二种， 通地token进行json字符串转换成对象集合
        TypeToken<List<Emplooy>> typeToken = new TypeToken<List<Emplooy>>(){};
        List<Emplooy> list1 = new Gson().fromJson(_json_arr, new TypeToken<List<Emplooy>>(){}.getType());

        Emimpl emimpl = new Emimpl("loiter"){};
       List<Integer> integerts = new ArrayList<Integer>(){
           @Override
           public boolean add(Integer integer) {
               return super.add(integer+ 10);
           }
       };

       integerts.add(23);

       log.info(integerts.toString());

        log.info("emimpl = " + emimpl + "  >>> " + emimpl.name);
        Emimpl emimpl1 = new Emimpl("brenda");
        log.info("emimpl1 = " + emimpl1+" >>> " + emimpl1.name);
    }
}

 class  Emimpl {

    final String name;

    public Emimpl(String name) {
        this.name = name;
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
