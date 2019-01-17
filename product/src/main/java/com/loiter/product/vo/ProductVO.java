package com.loiter.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @description: ProductVO
 * @author: ant-loiter
 * @date: 2019-01-17 15:03
 * 功能描述： 接口返回的商品信息
 */

@Data
public class ProductVO {

    // 表示返回json里面显示的名称为name， 分类名称
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private  Integer categoryType;

    @JsonProperty("foods")
    private List<ProdectInfoVO> productInfoList;
}
