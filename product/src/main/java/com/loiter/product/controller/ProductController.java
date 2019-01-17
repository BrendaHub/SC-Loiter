package com.loiter.product.controller;

import com.loiter.product.module.ProductCategory;
import com.loiter.product.module.ProductInfo;
import com.loiter.product.service.ProductCategoryService;
import com.loiter.product.service.ProductService;
import com.loiter.product.utils.ResultVOUtils;
import com.loiter.product.vo.ProdectInfoVO;
import com.loiter.product.vo.ProductVO;
import com.loiter.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: ProductController
 * @author: ant-loiter
 * @date: 2019-01-17 15:11
 * 功能描述： 商品请求控制类
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        // 获取所有上架商品列表
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 这是一个jdk8的流式语法； 可以拿到商品结果集中所有类目的信息并转换成集合
        List<Integer> categoryTypeList = productInfoList.stream()
                                            .map(ProductInfo::getCategoryType)
                                            .collect(Collectors.toList());
        // 这个可以获取到结果集中所有关于产品状态的记录；
        List<Integer> productStatusList = productInfoList.stream()
                                            .map(ProductInfo::getProductStatus)
                                            .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = productCategoryService.findAllProductCategory(categoryTypeList);

        // 构造接口返回的数据；

        List<ProductVO> productVOS = new ArrayList<>();
        for( ProductCategory productCategory : productCategoryList  ){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            // 遍历商品信息；先定义一个商品集合
            List<ProdectInfoVO> productInfoVO = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProdectInfoVO prodectInfoVO = new ProdectInfoVO();
                    // 这是一个将属性内容拷贝的快捷方式； 项目中推存使用
                    BeanUtils.copyProperties(productInfo, prodectInfoVO);
                    productInfoVO.add(prodectInfoVO);
                }
            }
            productVO.setProductInfoList(productInfoVO);
            productVOS.add(productVO);
        }

        return ResultVOUtils.success(productVOS);
    }
}
