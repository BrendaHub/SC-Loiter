package com.example.orderdemo.Dao;

import com.example.orderdemo.module.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
