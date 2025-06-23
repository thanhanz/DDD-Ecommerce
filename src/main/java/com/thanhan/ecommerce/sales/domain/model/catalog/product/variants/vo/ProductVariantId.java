package com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo;

import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.ProductVariant;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;
import lombok.NonNull;

import java.util.UUID;


public class ProductVariantId {

    private final @NonNull String id;

    public ProductVariantId(@NonNull String id) {
        var idVal = id.toString().strip();
        if (idVal.isEmpty())
            throw new IllegalArgumentException("Product variant id must not contain an empty string");
        this.id = idVal;
    }

    public static ProductVariantId generate() {
        return new ProductVariantId("PRD_VARIANT_" + UUID.randomUUID().toString());
    }

    public String value() {
        return id;
    }

}
