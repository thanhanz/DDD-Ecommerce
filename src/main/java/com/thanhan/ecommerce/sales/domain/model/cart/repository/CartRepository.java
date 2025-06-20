package com.thanhan.ecommerce.sales.domain.model.cart.repository;

import com.thanhan.ecommerce.sales.domain.model.cart.Cart;

public interface CartRepository {

    Cart findByUserId(String userId);
    void save(Cart cart);
}
