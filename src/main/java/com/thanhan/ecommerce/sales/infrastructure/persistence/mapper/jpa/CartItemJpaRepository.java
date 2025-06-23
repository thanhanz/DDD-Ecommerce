package com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.jpa;

import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.cart.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, String> {
}
