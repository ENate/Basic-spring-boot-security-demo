package com.enate.microservices.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enate.microservices.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
