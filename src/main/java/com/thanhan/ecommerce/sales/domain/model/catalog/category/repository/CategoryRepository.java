package com.thanhan.ecommerce.sales.domain.model.catalog.category.repository;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.Category;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;

import java.util.List;

public interface CategoryRepository {
    Category findById(CategoryId id);
    List<Category> getCategories();
}
