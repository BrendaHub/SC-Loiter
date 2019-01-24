package com.loiter.product.service.impl;

import com.loiter.product.dto.CartDto;
import com.loiter.product.module.ProductInfo;
import com.loiter.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();

        Assert.assertTrue(list.size() > 0 );
    }

    @Test
    public void deductProduct() {
        CartDto cartDto = new CartDto("157875227953464068", 3);
        productService.deductProduct(Arrays.asList(cartDto));

    }
}