package com.loiter.order.repository;

import com.loiter.order.enums.OrderStatusEnum;
import com.loiter.order.enums.PayStatusEnum;
import com.loiter.order.module.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {

        OrderMaster orderMaster = new OrderMaster();
        System.out.println(new UUID(99, 12333).toString().length());
        orderMaster.setOrderId(new UUID(99, 12333).toString());
        orderMaster.setBuyerName("Python");
        orderMaster.setBuyerAddress("beijing");
        orderMaster.setBuyerOpenid("adfadf");
        orderMaster.setBuyerPhone("13566666666");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderAmount(BigDecimal.valueOf(99));
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());


        OrderMaster orderMaster1 =  orderMasterRepository.save(orderMaster);

        Assert.assertTrue(orderMaster1 != null);
    }

}