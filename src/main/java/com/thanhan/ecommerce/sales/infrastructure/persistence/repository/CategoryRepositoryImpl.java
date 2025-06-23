package com.thanhan.ecommerce.sales.infrastructure.persistence.repository;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.Category;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.repository.CategoryRepository;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.CategoryId;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.jpa.CategoryJpaRepository;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.CategoryMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Category findById(CategoryId id) {
        return categoryJpaRepository.findById(Long.valueOf(id.value()))
                .map(CategoryMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Category is not exist in database"));
    }

    @Override
    public List<Category> getCategories() {

        log.info("Category Infras RepoImpl: {}", categoryJpaRepository.findAll());
        return categoryJpaRepository.findAll()
                .stream()
                .map(CategoryMapper::toDomain)
                .collect(Collectors.toList());
    }
}
