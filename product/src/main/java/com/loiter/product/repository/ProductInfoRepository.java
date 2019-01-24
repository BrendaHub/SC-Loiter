package com.loiter.product.repository;

import com.loiter.product.module.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @description: ProductInfoRepository
 * @author: ant-loiter
 * @date: 2019-01-17 11:54
 * 功能描述：productInfo表业务的Dao层代码
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    // 添加通过商品在线状态查询所有商品列表
    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productidlist);

}
