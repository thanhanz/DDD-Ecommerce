package com.thanhan.ecommerce.sales.domain.model.catalog.product.variants;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo.ProductVariantId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo.VariantOption;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Set;

@Getter
public class ProductVariant {

    private final ProductVariantId productVariantId;
    private final ProductId productId;
    private final Set<VariantOption> variantOptions;
    private Money price;

    public ProductVariant(ProductVariantId id, ProductId productId, Set<VariantOption> options, Money price) {
        this.productVariantId = id;
        this.productId = productId;
        this.variantOptions = options;
        this.price = price;
    }

    public static ProductVariant create(ProductId productId, Set<VariantOption> options, Money price) {
        if (productId == null) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }
        if (options == null || options.isEmpty()) {
            throw new IllegalArgumentException("Variant options cannot be null or empty");
        }
        if (price == null || price.value().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be null or negative");
        }

        ProductVariant variant = new ProductVariant(
                ProductVariantId.generate(),
                productId,
                options,
                price
        );

        /**
         * Raise Event created new Variant Product
         */
        return variant;
    }

    public void changePrice(Money newPrice) {
        if (newPrice == null || newPrice.value().intValue() < 0) {
            throw new IllegalArgumentException("Price cannot be null or zero");
        }
        this.price = newPrice;
    }


}
