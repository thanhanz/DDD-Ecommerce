package com.thanhan.ecommerce.sales.application.service.category;

import com.thanhan.ecommerce.sales.application.mapper.response.CategoryResponse;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.Category;

import java.util.List;

public interface CategoryAppService {
    List<CategoryResponse> getCategories();
}
