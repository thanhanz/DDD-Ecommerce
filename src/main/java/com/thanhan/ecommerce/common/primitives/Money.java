package com.thanhan.ecommerce.common.primitives;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public final class Money {
    public static final Money ZERO = new Money(0.f);

    private static final float MAXIMUM_VALUE = 1_000_000_000.0f; // 1 billion per Product

    private final float money;

    public Money(float money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be less than zero");
        }

        if (money > MAXIMUM_VALUE) {
            throw new IllegalArgumentException("Money cannot be greater than " + MAXIMUM_VALUE);
        }

        this.money = money;
    }

    public Money add(Money money) {
        return new Money(this.money + money.money);
    }

    public Money multiply(float multiplier) {
        return new Money(this.money * multiplier);
    }

    public float getValue() {
        return money;
    }
}
