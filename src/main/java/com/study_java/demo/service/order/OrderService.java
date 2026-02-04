package com.study_java.demo.service.order;

import com.study_java.demo.emuns.OrderStatus;
import com.study_java.demo.exceptions.ResourceNotFoundException;
import com.study_java.demo.models.Cart;
import com.study_java.demo.models.Order;
import com.study_java.demo.models.OrderItem;
import com.study_java.demo.models.Product;
import com.study_java.demo.repository.OrderRepository;
import com.study_java.demo.repository.ProductRepository;
import com.study_java.demo.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService  implements IOrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CartService cartService;

    @Override
    public Order placeOrder(Long userId) {
        Cart cart = cartService.getCartByUserId(userId);

        Order order = createOrder(cart);
        List<OrderItem> orderItemList = createOrderItems(order, cart);

        order.setOrderItems(new HashSet<>(orderItemList));
        order.setTotalAmount(calculateTotalAmount(orderItemList));

        Order savedOrder = orderRepository.save(order);
        cartService.clearCart(cart.getId());

        return savedOrder;
    }

    private Order createOrder(Cart cart) {
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setOrderStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDate.now());
        return order;
    }

    private List<OrderItem> createOrderItems(Order order, Cart cart) {
        return cart.getItems().stream().map(cartItem ->{
            Product product = cartItem.getProduct();
            product.setInventory(product.getInventory() - cartItem.getQuantity());
            productRepository.save(product);

            return  new OrderItem(
                    order,
                    product,
                    cartItem.getQuantity(),
                    cartItem.getUnitPrice()
            );
        }).toList();
    }

    private BigDecimal calculateTotalAmount(List<OrderItem> orderItem) {
        return orderItem
                .stream()
                .map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).
                orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
