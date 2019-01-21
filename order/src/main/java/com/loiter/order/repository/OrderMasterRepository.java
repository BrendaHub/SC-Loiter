package com.loiter.order.repository;

import com.loiter.order.module.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String > {
}
