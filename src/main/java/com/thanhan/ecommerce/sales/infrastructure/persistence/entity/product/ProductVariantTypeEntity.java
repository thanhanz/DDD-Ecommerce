package com.thanhan.ecommerce.sales.infrastructure.persistence.entity.product;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantTypeEntity {

    @Id
    @Column(name = "product_id", length = 36)
    private String productId;

    @Id
    @Column(name = "variant_type_name", length = 50)
    private String variantTypeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_type_name", insertable = false, updatable = false)
    private VariantTypeEntity variantType;

}
