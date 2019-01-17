package com.loiter.product.repository;

import com.loiter.product.module.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void  findByProductStatus() throws  Exception{

        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        System.out.println(list);
        Assert.assertTrue(list.size() > 0 );
    }
}