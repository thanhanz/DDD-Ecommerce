package com.thanhan.ecommerce.access_control.domain.model.valueObject;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class RoleId {
    private final @NonNull String id;

    public RoleId(@NonNull Object id) {
        var idVal = id.toString();
        if (idVal.isBlank()) {
            throw new IllegalArgumentException("Id cannot be empty");
        }
        this.id = idVal;
    }

    public @NonNull String getId() {
        return id;
    }
}
