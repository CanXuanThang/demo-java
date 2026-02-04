package com.study_java.demo.service.order;

import com.study_java.demo.dto.OrderDTO;
import com.study_java.demo.models.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDTO getOrder(Long orderId);

    List<OrderDTO> getUserOrders(Long userId);
}
