package com.loiter.order.service.impl;

import com.loiter.order.client.ProductClient;
import com.loiter.order.dto.CartDto;
import com.loiter.order.dto.OrderDto;
import com.loiter.order.enums.OrderStatusEnum;
import com.loiter.order.enums.PayStatusEnum;
import com.loiter.order.module.OrderDetail;
import com.loiter.order.module.OrderMaster;
import com.loiter.order.module.ProductInfo;
import com.loiter.order.repository.OrderDetailRepository;
import com.loiter.order.repository.OrderMasterRepository;
import com.loiter.order.service.OrderService;
import com.loiter.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDto create(OrderDto orderDto) {
        // 创建当前订单ID
        String OrderId = KeyUtils.getUniqueKey();
        // 查询商品信息（调用商品服务）
        // 根据商品ID查询出商品id集合, 在集合中获取某个字段的集合内容
        List<String> productIdlist = orderDto.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.findProductListByID(productIdlist);
        // 计算总价, 需要遍历找到每一个商品的采购数量，再在商品实例里面找到对应商品的单价
        BigDecimal totalPrice = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail : orderDto.getOrderDetailList()) {
            for(ProductInfo productInfo : productInfoList) {
                if(orderDetail.getProductId().equals(productInfo.getProductId())) {
                    totalPrice = productInfo.getProductPrice()
                            .multiply(BigDecimal.valueOf(orderDetail.getProductQuantity()))
                            .add(totalPrice);
                    // 这里需要将订单里面的每一个商品信息入库，orderDetail,当时orderDetail对象里面只有商品ID和商品数量
                    BeanUtils.copyProperties(productInfo, orderDetail);// 将商品对象里面的属性拷贝到订单详情对象中。
                    orderDetail.setOrderId(OrderId);
                    orderDetail.setDetailId(KeyUtils.getUniqueKey());
                    OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
                }

            }
        }
        // 扣库存（调用商品服务）
        List<CartDto> cartDtos = orderDto.getOrderDetailList().stream()
                .map(e -> new CartDto(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.deductProductStock(cartDtos);
        // 最后订单入库
        OrderMaster orderMaster = new OrderMaster();
        // 先生成一个唯一的订单ID， 在同一个订单的不同实体里的订单id要唯一
        orderDto.setOrderId(OrderId);
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(totalPrice);  // 回存当前订单的总金额
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster om = orderMasterRepository.save(orderMaster);

        BeanUtils.copyProperties(orderMaster, orderDto);

        return orderDto;
    }
}
