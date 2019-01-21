package com.loiter.order.repository;

import com.loiter.order.module.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
