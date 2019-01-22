package com.example.orderdemo.Dao;

import com.example.orderdemo.module.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
