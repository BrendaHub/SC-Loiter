package com.loiter.product.service.impl;

import com.loiter.product.module.ProductCategory;
import com.loiter.product.repository.ProductCategoryRepository;
import com.loiter.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findAllProductCategory(List<Integer> categoryList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryList);
    }

}
