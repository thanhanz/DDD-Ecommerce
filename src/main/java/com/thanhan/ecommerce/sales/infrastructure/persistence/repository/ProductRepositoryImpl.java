package com.thanhan.ecommerce.sales.infrastructure.persistence.repository;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.Uri;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.repository.ProductRepository;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.jpa.ProductJpaRepository;
import com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product findById(ProductId id) {
        return productJpaRepository.findById(id.value())
                .map(ProductMapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Product in database is not exist!!"));
    }

//    @Override
//    public List<Product> findByCategoryId(CategoryId categoryId) {
//        return productJpaRepository.findByCategories_Id(categoryId.value())
//                .stream()
//                .map(ProductMapper::toDomain)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<Product> findByUri(Uri categoryUri) {
        return productJpaRepository.findByCategoryUri(categoryUri.value())
                .stream()
                .map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public void save(Product product) {
        productJpaRepository.save(ProductMapper.toEntity(product));
    }

    @Override
    public void delete(Product product) {
        productJpaRepository.delete(ProductMapper.toEntity(product));
    }
}
