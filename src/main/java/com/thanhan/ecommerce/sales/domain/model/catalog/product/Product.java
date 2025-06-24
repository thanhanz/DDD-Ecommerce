package com.thanhan.ecommerce.sales.domain.model.catalog.product;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.common.primitives.Quantity;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.ProductVariant;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo.*;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.Description;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;
import lombok.Getter;

import java.util.*;

@Getter
public class Product {

    private final ProductId id;
    private Title title;
    private Description description;
    private Set<CategoryId> categories;
    private List<ProductVariant> variants;

    public Product(ProductId id, Title title, Description description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categories = new HashSet<>();
        this.variants = new ArrayList<>();
    }

    /**
     * Core business methods: addVariant(), removeVariant()
     * Query methods: getVariantsByType(), findVariantBySku(), getAvailableVariants(), getTotalStock()
     */

    public static Product create(Title title, Description description) {
        Product p = new Product(ProductId.generate(), title, description);
        /**
         *
         * Publish Event ProductCreated
         */
        return p;
    }

    public ProductVariant addProductVariant(VariantType type, VariantValue option,
                                  Sku sku, Money price, Title title, Quantity stock) {

        if (checkDuplicateVariantTypeAndOption(type, option)) {
            throw new IllegalArgumentException("Variant type and option cannot be duplicated");
        }

        Map<VariantType, VariantValue> options = new HashMap<>();
        options.put(type, option);

        ProductVariant variant = new ProductVariant(ProductVariantId.generate(), this.id, sku, options,title, price, stock);
        this.variants.add(variant);

        /**
         * Publish event add new ProductVariant
         */
        return variant;
    }

    private boolean checkDuplicateVariantTypeAndOption(VariantType type, VariantValue option) {
        return variants.stream()
                .anyMatch(v ->
                        option.equals(v.getVariantOptions().get(type)));

    }

    public void changeTitle(Title newTitle) {
        if (newTitle == null || newTitle.value().isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = newTitle;
    }

    public void changeDescription(Description newDescription) {
        if (newDescription == null || newDescription.value().isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = newDescription;
    }

    public void removeProductVariant(ProductVariant productVariant) {
        this.variants.removeIf(variant -> variant.getProductId().equals(productVariant.getProductId()));
    }

    public void categorize(CategoryId categoryId) {
        if (categoryId == null || categoryId.value().isBlank()) {
            throw new IllegalArgumentException("CategoryId cannot be null or empty");
        }
        categories.add(categoryId);
    }


}
