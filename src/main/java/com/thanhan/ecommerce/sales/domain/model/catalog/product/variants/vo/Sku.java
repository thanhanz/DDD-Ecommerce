package com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Sku {

    private final @NonNull String sku;

    public Sku(@NonNull String sku) {
        var val = sku.strip();
        if (val.isBlank()) {
            throw new IllegalArgumentException("SKU cannot be empty!");
        }
        this.sku = sku;
    }

    public String value() {
        return sku;
    }
}
