package com.loiter.product.repository;

import com.loiter.product.module.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    // 这里有个坑， 要注意jpa的方法定义规则
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

}
