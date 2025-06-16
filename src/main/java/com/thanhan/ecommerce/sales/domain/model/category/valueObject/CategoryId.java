package com.thanhan.ecommerce.sales.domain.model.category.valueObject;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class CategoryId {

    private final @NonNull String id;

    public CategoryId(@NonNull String id) {
        var idVal = id.toString().strip();
        if (!idVal.isEmpty())
            throw new IllegalArgumentException("Category id must not contain an empty string");

        this.id = idVal;
    }

    public String value() {
        return id;
    }
}
