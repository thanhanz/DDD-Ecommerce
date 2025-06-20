package com.thanhan.ecommerce.sales.infrastructure.persistence.mapper;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.Category;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.Title;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.Uri;
import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.CategoryEntity;

public class CategoryMapper {

    public static Category toDomain(CategoryEntity entity) {
        if (entity == null) return null;
        return new Category(new CategoryId(String.valueOf(entity.getId())),
                            new Title(entity.getTitle()),
                            new Uri(entity.getUri()));

    }

    public static CategoryEntity toEntity(Category domain) {
        if (domain == null) return null;

        CategoryEntity entity = new CategoryEntity();
        entity.setId(Long.valueOf(domain.getCategoryId().value()));
        entity.setTitle(domain.getTitle().value());
        entity.setUri(domain.getUri().value());

        return entity;
    }
}
