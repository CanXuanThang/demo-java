package com.study_java.demo.service.order;

import com.study_java.demo.models.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    Order getOrder(Long orderId);

    List<Order> getUserOrders(Long userId);
}
