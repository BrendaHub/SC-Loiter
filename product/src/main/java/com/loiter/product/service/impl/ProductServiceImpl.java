package com.loiter.product.service.impl;

import com.loiter.product.enums.ProductStatusEnum;
import com.loiter.product.module.ProductInfo;
import com.loiter.product.repository.ProductCategoryRepository;
import com.loiter.product.repository.ProductInfoRepository;
import com.loiter.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductInfo> findUpAll() {

        List<ProductInfo> result = productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());

        return result;
    }
}
