package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.OrderStatus;

@Repository
public interface OrderStatusRepo extends JpaRepository<OrderStatus, Long> {

}
