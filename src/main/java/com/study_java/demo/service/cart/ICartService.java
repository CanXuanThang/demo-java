package com.study_java.demo.service.cart;

import com.study_java.demo.dto.CartDTO;
import com.study_java.demo.models.Cart;
import com.study_java.demo.models.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Cart initializeCart(User user);
    Cart getCartByUserId(Long userId);

    CartDTO convertCartToDTO(Cart cart);
}
