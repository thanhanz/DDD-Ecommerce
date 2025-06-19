package com.thanhan.ecommerce.sales.domain.model.catalog.category;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.Title;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.Uri;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.Description;
import lombok.Getter;


@Getter
public class Category {

    private final CategoryId categoryId;
    private Title title;
    private Uri uri;

    public Category(CategoryId categoryId, Title title, Uri uri) {
        this.categoryId = categoryId;
        this.title = title;
        this.uri= uri;
    }

    public static Category create(CategoryId categoryId, Title title, Uri uri) {
        return new Category(categoryId, title, uri);
    }


    public void changeTitle(Title newTitle) {
        if (newTitle == null || newTitle.value().isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = newTitle;
    }
}
