package com.thanhan.ecommerce.sales.infrastructure.persistence.mapper.jpa;

import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
}
