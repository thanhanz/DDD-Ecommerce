package com.thanhan.ecommerce.sales.domain.model.catalog.product.variants;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.common.primitives.Quantity;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo.*;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class ProductVariant {

    private final ProductVariantId productVariantId;
    private final ProductId productId;
    private final Map<VariantType, VariantValue> variantOptions;
    private final Sku sku;
    private Title title;
    private Money price;
    private Quantity stock;

    public ProductVariant(ProductVariantId id, ProductId productId, Sku sku, Map<VariantType, VariantValue> variantOptions, Title title, Money price, Quantity stock) {
        this.productVariantId = id;
        this.productId = productId;
        this.variantOptions = variantOptions;
        this.price = price;
        this.sku = sku;
        this.title = title;
        this.stock = stock;
    }

    public void changePrice(Money newPrice) {
        if (newPrice == null || newPrice.value().intValue() < 0) {
            throw new IllegalArgumentException("Price cannot be null or zero");
        }
        this.price = newPrice;
    }

    //Update new stock (NOT for payment)
    public void updateStock(Quantity newStock) {
        this.stock.add(newStock);
    }

}
