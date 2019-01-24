package com.loiter.product.service;

import com.loiter.product.dto.CartDto;
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

    List<ProductInfo> findProductList(List<String> productidlist);

    // 添加一个扣除商品的业务方法
    // cartDtoList,是传过来的商品id和需要扣除的商品数量
    void deductProduct(List<CartDto> cartDtoList);
}
