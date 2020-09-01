package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.OrderReceived;

@Repository
public interface OrderReceivedRepo extends JpaRepository<OrderReceived, Long> {

}
