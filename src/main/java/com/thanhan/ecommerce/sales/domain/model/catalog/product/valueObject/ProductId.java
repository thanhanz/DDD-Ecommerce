package com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject;

import lombok.NonNull;

public class ProductId {

    private final @NonNull String id;

    public ProductId(@NonNull String id) {
        var idVal = id.toString().strip();
        if (!idVal.isEmpty())
            throw new IllegalArgumentException("Product id must not contain an empty string");

        this.id = idVal;
    }

    public String value() {
        return id;
    }

}
