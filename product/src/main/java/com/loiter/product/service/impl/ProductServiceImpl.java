package com.loiter.product.service.impl;

import com.loiter.product.dto.CartDto;
import com.loiter.product.enums.ProductNumberEnum;
import com.loiter.product.enums.ProductStatusEnum;
import com.loiter.product.exception.ProductException;
import com.loiter.product.module.ProductInfo;
import com.loiter.product.repository.ProductCategoryRepository;
import com.loiter.product.repository.ProductInfoRepository;
import com.loiter.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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

    @Override
    public List<ProductInfo> findProductList(List<String> productidlist) {
        return productInfoRepository.findByProductIdIn(productidlist);
    }

    @Override
    @Transactional // 添加事物支持
    public void deductProduct(List<CartDto> cartDtoList) {
        // 第一步， 判断参数的扣除的前置条件
        for(CartDto cartDto : cartDtoList) {
            Optional<ProductInfo> optionalProduct = productInfoRepository.findById(cartDto.getProductId());
            // 判断获取的的商品是否存在，
            if(!optionalProduct.isPresent()) {
                log.error("【扣除商品库存】异常， 异常信息为={}", ProductNumberEnum.PRODUCT_EMPTRY.getMessage());
                throw new ProductException(ProductNumberEnum.PRODUCT_EMPTRY);
            } else {
                // 判断当前数量是否可以完成本次订单的数量
                ProductInfo productInfo = optionalProduct.get();
                Integer stockNew = productInfo.getProductStock() - cartDto.getProductQuantity();
                if (stockNew < 0 ){
                    log.error("【扣除商品库存】异常， 异常信息为为={}", ProductNumberEnum.PRODUCT_NOT_MORE.getMessage());
                    throw new ProductException(ProductNumberEnum.PRODUCT_NOT_MORE);
                }

                // 可以正常的扣除库存
                productInfo.setProductStock(stockNew); // 设置新的库存
                productInfoRepository.save(productInfo);//更新数据库；
            }
        }
    }
}
