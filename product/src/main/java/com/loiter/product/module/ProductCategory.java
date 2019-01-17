package com.loiter.product.module;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @description: ProductCategory
 * @author: ant-loiter
 * @date: 2019-01-17 13:56
 * 功能描述： 商品类目实体类
 */
@Entity
@Data
public class ProductCategory {

    // 自增的类目ID
    @Id
    @GeneratedValue
   private Integer categoryId;

    // 商品类止的名称
    private String categoryName;

    // 商品类目编号
    private Integer categoryType;

    // 记录创建时间
    private Date createTime;

    // 记录修改时间
    private Date updateTime;
}
