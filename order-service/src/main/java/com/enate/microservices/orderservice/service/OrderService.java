package com.enate.microservices.orderservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enate.microservices.orderservice.dto.OrderRequest;
import com.enate.microservices.orderservice.model.Order;
import com.enate.microservices.orderservice.repository.OrderRepository;


@Service
@Transactional // Provides necessary interceptions and transaction control
public class OrderService {

    // Inject the OrderRepository
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(OrderRequest orderRequest) {
        var order = entityMapToOrder(orderRequest);
        orderRepository.save(order);
    }


    private static Order entityMapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        return order;
    }
}
