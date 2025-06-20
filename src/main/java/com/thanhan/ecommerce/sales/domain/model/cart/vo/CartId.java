package com.thanhan.ecommerce.sales.domain.model.cart.vo;

import com.thanhan.ecommerce.sales.domain.model.cart.item.ProductId;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.UUID;

@EqualsAndHashCode
@ToString
public class CartId {

    private final @NonNull String id;

    public CartId(@NonNull String id) {
        var idVal = id.toString().strip();
        if (idVal.isEmpty())
            throw new IllegalArgumentException("Product id must not contain an empty string");
        this.id = idVal;
    }

    public static CartId generate() {
        return new CartId(UUID.randomUUID().toString());
    }

    public String value() {
        return id;
    }
}
