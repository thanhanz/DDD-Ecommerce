package com.thanhan.ecommerce.sales.domain.model.cart.item;

import lombok.NonNull;

import java.util.UUID;

public class ProductId {


    private final @NonNull String id;

    public ProductId(@NonNull String id) {
        var idVal = id.toString().strip();
        if (idVal.isEmpty())
            throw new IllegalArgumentException("Product id must not contain an empty string");
        this.id = idVal;
    }

    public static ProductId generate() {
        return new ProductId("PRD_" + UUID.randomUUID().toString());
    }

    public String value() {
        return id;
    }
}
