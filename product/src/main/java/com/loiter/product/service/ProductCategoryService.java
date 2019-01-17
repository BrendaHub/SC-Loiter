package com.loiter.product.service;

import com.loiter.product.module.ProductCategory;

import java.util.List;

/**
 * @description: ProductCategoryService
 * @author: ant-loiter
 * @date: 2019-01-17 14:44
 * 功能描述： 商品类目业务类
 */
public interface ProductCategoryService {

    List<ProductCategory> findAllProductCategory(List<Integer> categoryList);
}
