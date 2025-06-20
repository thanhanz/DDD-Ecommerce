package com.thanhan.ecommerce.sales.domain.model.cart.item;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.common.primitives.Quantity;
import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public final class CartItem {

    private final @NonNull ProductId productId;
    private final @NonNull Title title;
    private final @NonNull Quantity quantity;
    private final @NonNull Money unitPrice;

    public Money totalPrice() {
        return this.unitPrice.multiply(this.quantity.getValue());
    }
}
