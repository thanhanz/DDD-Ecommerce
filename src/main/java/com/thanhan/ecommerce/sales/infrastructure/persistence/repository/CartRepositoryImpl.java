package com.thanhan.ecommerce.sales.infrastructure.persistence.repository;

import com.thanhan.ecommerce.sales.domain.model.cart.Cart;
import com.thanhan.ecommerce.sales.domain.model.cart.repository.CartRepository;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.jpa.CartJpaRepository;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.CartMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Transactional
public class CartRepositoryImpl implements CartRepository {

    private final CartJpaRepository cartJpaRepository;

    @Override
    public Cart findByUserId(String userId) {
        return cartJpaRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Cart from user doesn't exist!"));
    }

    @Override
    public void save(Cart cart) {
        cartJpaRepository.save(CartMapper.toEntity(cart));
    }
}
