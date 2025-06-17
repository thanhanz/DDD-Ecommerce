package com.thanhan.ecommerce.common.primitives;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
public final class Money {

    private static final BigDecimal MAXIMUM_VALUE = new BigDecimal(1_000_000_000); // 1 billion per Product

    private final BigDecimal money;

    public Money(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money cannot be less than zero");
        }

        if (money.compareTo(MAXIMUM_VALUE) > 0) {
            throw new IllegalArgumentException("Money cannot be greater than " + MAXIMUM_VALUE.floatValue());
        }

        this.money = money;
    }

    public Money add(Money money) {
        return new Money(this.money.add(money.money));
    }

    public Money multiply(float multiplier) {
        return new Money(this.money.multiply(new BigDecimal(multiplier)));
    }

    public BigDecimal value() {
        return money;
    }
}
