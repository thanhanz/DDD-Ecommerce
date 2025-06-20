package com.thanhan.ecommerce.sales.domain.model.cart;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.common.primitives.Quantity;
import com.thanhan.ecommerce.sales.domain.model.cart.item.CartItem;
import com.thanhan.ecommerce.sales.domain.model.cart.item.ProductId;
import com.thanhan.ecommerce.sales.domain.model.cart.vo.CartId;
import com.thanhan.ecommerce.sales.domain.model.cart.vo.UserId;
import lombok.*;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public final class Cart {

    private final @NonNull CartId cartId;
    private final @NonNull UserId owner;
    private final @NonNull List<CartItem> cartItems;

    public boolean hasItems() {
        return cartItems.size() > 0;
    }

    public void addItem(CartItem addItem) {
        if (hasItem(addItem)) {
            for (int i = 0; i < cartItems.size(); i++) {
                CartItem oldItem = cartItems.get(i);
                if (oldItem.getProductId().equals(addItem.getProductId())) {
                    Quantity newQuantity = oldItem.getQuantity().add(addItem.getQuantity());
                    Money newUnitPrice = oldItem.getUnitPrice()
                            .add(oldItem.getUnitPrice().multiply(newQuantity.getValue()));
                    CartItem updatedItem = new CartItem(oldItem.getProductId(),
                            oldItem.getTitle(),
                            newQuantity,
                            newUnitPrice);

                    cartItems.set(i, updatedItem);
                    return;
                }
            }
        }
        cartItems.add(addItem);
    }

    public void removeItem(ProductId productId) {
        this.cartItems.removeIf(item -> item.getProductId().equals(productId));
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(cartItems);
    }

    private boolean hasItem(CartItem cartItem) {
        for (CartItem item : cartItems) {
            if (item.getProductId().equals(cartItem.getProductId())) {
                return true;
            }
        }
        return false;
    }
}
