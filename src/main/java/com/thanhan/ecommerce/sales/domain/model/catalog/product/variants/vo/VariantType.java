package com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo;

import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class VariantType {
    @NonNull String name;

    public VariantType(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Variant type cannot be null");
        }
        this.name = name.strip();
    }

    public String value() {
        return this.name;
    }
}
