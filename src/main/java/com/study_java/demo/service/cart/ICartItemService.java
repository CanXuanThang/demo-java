package com.study_java.demo.service.cart;

import com.study_java.demo.models.Cart;
import com.study_java.demo.models.CartItem;

import java.math.BigDecimal;

public interface ICartItemService {
    void addItemToCart(Long cartId, Long productId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemQuantity(Long cartId, Long productId, int quantity);

    CartItem getCartItem(Long cartId, Long productId);
}
