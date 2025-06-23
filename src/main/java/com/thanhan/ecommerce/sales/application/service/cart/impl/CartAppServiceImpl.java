package com.thanhan.ecommerce.sales.application.service.cart.impl;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.application.service.cart.CartAppService;
import com.thanhan.ecommerce.sales.domain.model.cart.Cart;
import com.thanhan.ecommerce.sales.domain.model.cart.repository.CartRepository;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.jpa.CartItemJpaRepository;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.jpa.CartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartAppServiceImpl implements CartAppService {

    private final CartRepository cartRepository;
    private final CartJpaRepository cartJpaRepository;
    private final CartItemJpaRepository cartItemJpaRepository;

    @Override
    public void addItem(String userId, String productId, int quantity) {
//        Cart cart = cartRepository.findByUserId(userId);
//
//        if (cart.hasItems())
//            cart.addItem(new CartItem());

    }

    @Override
    public void removeItem(String userId, String productId) {

    }

    @Override
    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public void clearCart(String userId) {

    }

    @Override
    public Money calculateTotal(String userId) {
        return null;
    }
}
