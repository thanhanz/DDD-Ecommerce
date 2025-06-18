package com.thanhan.ecommerce.sales.infrastructure.persistence.mapper;

import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJPAMapper extends JpaRepository<ProductEntity, String> {

    List<ProductEntity> findByCategoryId(String categoryId);
}
