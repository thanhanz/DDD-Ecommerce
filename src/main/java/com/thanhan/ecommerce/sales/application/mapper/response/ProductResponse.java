package com.thanhan.ecommerce.sales.application.mapper.response;

import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;

import java.math.BigDecimal;

public record ProductResponse(String id,
                              String title,
                              String description,
                              BigDecimal price) {

    public static ProductResponse from(Product product) {
                return new ProductResponse(
                        product.getId().value(),
                        product.getTitle().value(),
                        product.getDescription().value(),
                        product.getPrice().value()
                );
            }

}
