package com.loiter.product.service;

import com.loiter.product.module.ProductInfo;

import java.util.List;

/**
 * @description: ProductService
 * @author: ant-loiter
 * @date: 2019-01-17 14:30
 * 功能描述： 商品的业务接口
 */
public interface ProductService {

    // 查询所有上架商品
    List<ProductInfo> findUpAll();
}
