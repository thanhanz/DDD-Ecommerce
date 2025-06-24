package com.thanhan.ecommerce.sales.infrastructure.persistence.entity.product;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product_variants")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantEntity {


    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "sku", unique = true, nullable = false, length = 50)
    private String sku;

    @Column(name = "price", precision = 19, scale = 2, nullable = false)
    private BigDecimal price;

//    @Column(name = "currency", length = 3, nullable = false)
//    private String currency;
//
    @Column(name="stock")
    private Integer stock;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToMany(mappedBy = "productVariants", fetch = FetchType.LAZY)
    private Set<VariantValueEntity> variantValues = new HashSet<>();

}
