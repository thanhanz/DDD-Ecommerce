package com.thanhan.ecommerce.sales.infrastructure.persistence.entity.product;


import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.CategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "variant_values")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VariantValueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variants_id", nullable = false)
    private VariantEntity variant;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_variant_values",
            joinColumns = @JoinColumn(name = "variant_values_id"),
            inverseJoinColumns = @JoinColumn(name = "product_variant_id")
    )
    private Set<ProductVariantEntity> productVariants;
}
