package com.thanhan.ecommerce.sales.infrastructure.persistence.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantOptionEntity {

    @Column(name = "type")
    private String type; // e.g. "Color", "Size"

    @Column(name = "value")
    private String value; // e.g. "Red", "L"
}
