package com.thanhan.ecommerce.sales.infrastructure.persistence.repository;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.Description;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.ProductId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.Title;
import com.thanhan.ecommerce.sales.domain.repository.ProductRepository;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.ProductJPAMapper;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJPAMapper productJPAMapper;

    @Override
    public Product findById(ProductId id) {
        return productJPAMapper.findById(id.value())
                .map(ProductMapper::toDomain)
                .orElse(null);
//        .orElseThrow(() -> new EntityNotFoundException("Product is not exist!!"));
    }

    @Override
    public List<Product> findByCategoryId(CategoryId categoryId) {
        return productJPAMapper.findByCategoryId(categoryId.value())
                .stream()
                .map(ProductMapper::toDomain)
                .collect(Collectors.toList());
    }
}
