package com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.jpa;

import com.thanhan.ecommerce.sales.domain.model.cart.Cart;
import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.cart.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartJpaRepository extends JpaRepository<CartEntity, String> {
    Optional<Cart> findByUserId(String userId);
}
