package com.thanhan.ecommerce.sales.domain.model.catalog.product.vo;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Description{

    private final @NonNull String description;

    public Description(String description) {
        this.description = description != null ? description.strip() : "";
    }

    public String value() {
        return description;
    }

}
