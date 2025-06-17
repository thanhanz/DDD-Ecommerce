package com.thanhan.ecommerce.sales.infrastructure.persistence.entity;

import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.Title;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price_amount")
    private BigDecimal priceAmount;

//    @Column(name = "price_currency")
//    private String priceCurrency;

    @Column(name = "category_id")
    private String categoryId;

}

