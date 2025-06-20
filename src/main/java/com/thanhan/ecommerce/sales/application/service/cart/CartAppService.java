package com.thanhan.ecommerce.sales.application.service.cart;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.domain.model.cart.Cart;

public interface CartAppService {
    void addItem(String userId, String productId, int quantity);
    void removeItem(String userId, String productId);
    Cart getCartByUserId(String userId);
    void clearCart(String userId);
    Money calculateTotal(String userId);
}

