package com.thanhan.ecommerce.sales.domain.model.cart.vo;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class UserId {

    private final String id;

    public UserId(@NonNull String id) {
        var value = id.strip();
        if (value.isBlank()) {
            throw new IllegalArgumentException("UserId cannot be blank");
        }
        this.id = value;
    }

    public String value() {
        return id;
    }
}
