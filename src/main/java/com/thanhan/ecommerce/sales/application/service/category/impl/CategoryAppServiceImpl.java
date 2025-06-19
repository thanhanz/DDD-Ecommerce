package com.thanhan.ecommerce.sales.application.service.category.impl;

import com.thanhan.ecommerce.sales.application.mapper.response.CategoryResponse;
import com.thanhan.ecommerce.sales.application.service.category.CategoryAppService;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.Category;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryAppServiceImpl implements CategoryAppService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getCategories() {
        return categoryRepository.getCategories()
                .stream()
                .map(CategoryResponse::from)
                .collect(Collectors.toList());
    }
}
