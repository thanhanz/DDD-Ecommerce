package com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo;


import lombok.*;


@EqualsAndHashCode
@ToString
@Getter
public class VariantOption {
    private @NonNull String type; //Size, Storage, Color
    private @NonNull String value; //M, L, XL, 256G, Red, Blue

    public VariantOption(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String value() {
        return "This type is " + type + " and value is " + value;
    }
}
