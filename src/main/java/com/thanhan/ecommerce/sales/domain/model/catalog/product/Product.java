package com.thanhan.ecommerce.sales.domain.model.catalog.product;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.ProductVariant;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo.ProductVariantId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo.VariantOption;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.VariantType;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.Description;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.Title;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Product {

    private final ProductId id;
    private Title title;
    private Description description;
    private Set<CategoryId> categories;
    private Set<VariantType> variantTypes;
    private List<ProductVariantId> variantIds;

    public Product(ProductId id, Title title, Description description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categories = new HashSet<>();
        this.variantTypes = new HashSet<>();
        this.variantIds = new ArrayList<>();
    }

    public static Product create(Title title, Description description, Set<VariantType> types) {
        Product p = new Product(ProductId.generate(), title, description);

        if (types != null && !types.isEmpty()) {
            p.variantTypes.addAll(types);
        }

        /**
         *
         * Publist Event ProductCreated
         */
        return p;
    }

    public void addVariantType(VariantType type) {
        this.variantTypes.add(type);
    }

    public void addVariant(ProductVariantId id) {
        if (variantIds == null || variantIds.isEmpty())
            throw new IllegalArgumentException("VariantId cannot be null ");
        this.variantIds.add(id);
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

    public void removeProductVariant(ProductVariantId variantId) {
        this.variantIds.removeIf(vId -> vId.equals(variantId));
    }

    public void categorize(CategoryId categoryId) {
        if (categoryId == null || categoryId.value().isBlank()) {
            throw new IllegalArgumentException("CategoryId cannot be null or empty");
        }
        categories.add(categoryId);
    }

}
