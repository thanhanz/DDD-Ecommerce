package com.thanhan.ecommerce.common.primitives;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
public final class Quantity {

    public static final Quantity ZERO = new Quantity(0);
    public static final Quantity ONE = new Quantity(1);

    private final int quantity;

    public Quantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than zero!");
        }

        this.quantity = quantity;
    }

    public int getValue() {
        return this.quantity;
    }

    public Quantity add(Quantity other) {
        return new Quantity(this.quantity + other.getValue());
    }

    public Quantity minus(Quantity other) {
        return new Quantity(this.quantity - other.getValue());
    }

}
