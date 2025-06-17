package com.thanhan.ecommerce.sales.domain.model.catalog.product;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.Description;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.ProductId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.Title;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Product {

    private final ProductId id;
    private Title title;
    private Description description;
    private Money price;
    private CategoryId categoryId;

    public Product(ProductId id, Title title, Description description, Money price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public static Product create(@NonNull ProductId id, Title title, Description description, Money price) {
        return new Product(id, title, description, price);
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

    public void changePrice(Money newPrice) {
        if (newPrice == null || newPrice.value().intValue() < 0) {
            throw new IllegalArgumentException("Price cannot be null or zero");
        }
        this.price = newPrice;
    }

    public void categorize(CategoryId categoryId) {
        if (categoryId == null || categoryId.value().isBlank()) {
            throw new IllegalArgumentException("CategoryId cannot be null or empty");
        }
        this.categoryId = categoryId;
    }




}
