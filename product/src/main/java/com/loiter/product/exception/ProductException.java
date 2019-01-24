package com.loiter.product.exception;

import com.loiter.product.enums.ProductNumberEnum;
import com.loiter.product.enums.ProductStatusEnum;

/**
 * @description: ProductException
 * @author: ant-loiter
 * @date: 2019-01-24 14:37
 * 功能描述：  商品类相关的异常自定义处理类
 */
public class ProductException extends RuntimeException {

    private Integer Code;

    private String mesg;

    public ProductException(Integer code , String message) {
        super(message);
        this.Code  = code;
    }

    public ProductException(ProductNumberEnum productNumberEnum) {
        super(productNumberEnum.getMessage());
        this.Code = productNumberEnum.getCode();
    }
}
