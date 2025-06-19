package com.thanhan.ecommerce.sales.application.mapper.response;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.Category;

public record CategoryResponse(String id, String title, String uri) {

    public static CategoryResponse from(Category category) {
        return new CategoryResponse(
                category.getCategoryId().value(),
                category.getTitle().value(),
                category.getUri().value()
        );
    }
}
