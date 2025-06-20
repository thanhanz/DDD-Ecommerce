package com.thanhan.ecommerce.sales.infrastructure.persistence.mapper;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.common.primitives.Quantity;
import com.thanhan.ecommerce.sales.domain.model.cart.Cart;
import com.thanhan.ecommerce.sales.domain.model.cart.item.CartItem;
import com.thanhan.ecommerce.sales.domain.model.cart.item.ProductId;
import com.thanhan.ecommerce.sales.domain.model.cart.item.Title;
import com.thanhan.ecommerce.sales.domain.model.cart.vo.CartId;
import com.thanhan.ecommerce.sales.domain.model.cart.vo.UserId;
import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.CartEntity;
import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.CartItemEntity;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public static Cart toDomain(CartEntity entity) {
        List<CartItem> items = entity.getItems().stream()
                .map(CartMapper::toDomainItem)
                .collect(Collectors.toList());

        return new Cart(
                new CartId(entity.getId()),
                new UserId(entity.getUserId()),
                items
        );
    }

    public static CartEntity toEntity(Cart cart) {
        List<CartItemEntity> itemEntities = cart.getItems().stream()
                .map(CartMapper::toEntityItem)
                .collect(Collectors.toList());

        CartEntity entity = CartEntity.builder()
                .id(cart.getCartId().value())
                .userId(cart.getOwner().value())
                .items(itemEntities)
                .createdAt(Instant.now())
                .build();

        itemEntities.forEach(item -> item.setCart(entity)); // set back reference

        return entity;
    }

    private static CartItem toDomainItem(CartItemEntity entity) {
        return new CartItem(
                new ProductId(entity.getProductId()),
                new Title(entity.getTitle()),
                new Quantity(entity.getQuantity()),
                new Money(entity.getUnitPrice())
        );
    }

    private static CartItemEntity toEntityItem(CartItem item) {
        return CartItemEntity.builder()
                .productId(item.getProductId().value())
                .title(item.getTitle().value())
                .quantity(item.getQuantity().getValue())
                .unitPrice(item.getUnitPrice().value())
                .build();
    }
}
