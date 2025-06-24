package com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo;


import lombok.*;


@EqualsAndHashCode
@ToString
@Getter
public class VariantValue {
    @NonNull String value;

    public VariantValue(String value    ) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Variant Value cannot be null");
        }
        this.value = value.strip();
    }

    public String value() {
        return this.value;
    }
}
