package com.loiter.product.repository;

import com.loiter.product.module.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

//@Component

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {//extends ProductInfoRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryTypeTest() throws Exception{

        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,22));

        Assert.assertTrue(list.size() > 0);

    }
}