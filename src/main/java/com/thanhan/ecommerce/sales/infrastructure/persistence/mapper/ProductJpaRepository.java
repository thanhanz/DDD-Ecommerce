package com.thanhan.ecommerce.sales.infrastructure.persistence.mapper;

import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, String> {
//    List<ProductEntity> findByCategories_Id(String categoryId);

    @Query(value = "SELECT p.* FROM products p " +
            "JOIN products_categories pc ON p.id = pc.product_id " +
            "JOIN categories c ON c.id = pc.category_id " +
            "WHERE c.uri = :categoryUri", nativeQuery = true)
    List<ProductEntity> findByCategoryUri(@Param("categoryUri") String categoryUri);


}
