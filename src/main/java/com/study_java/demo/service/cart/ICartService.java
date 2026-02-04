package com.study_java.demo.service.cart;

import com.study_java.demo.models.Cart;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Long initializeCart();

    Cart getCartByUserId(Long userId);
}
