package com.thanhan.ecommerce.sales.infrastructure.persistence.mapper;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.Description;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.ProductId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.Title;
import com.thanhan.ecommerce.sales.infrastructure.persistence.entity.ProductEntity;

public class ProductMapper {

    public static Product toDomain(ProductEntity product) {
        if (product == null) return null;

       Product productDomain = new Product(
                new ProductId(product.getId()),
                new Title(product.getTitle()),
                new Description(product.getDescription()),
                new Money(product.getPriceAmount())
       );

        if (product.getCategoryId() != null) {
            productDomain.categorize(new CategoryId(product.getCategoryId()));
        }

        return productDomain;
    }

    public static ProductEntity toEntity(Product productDomain) {
        if (productDomain == null) return null;

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDomain.getId().value());
        productEntity.setTitle(productDomain.getTitle().value());
        productEntity.setDescription(productDomain.getDescription().value());
        productEntity.setPriceAmount(productDomain.getPrice().value());

        if (productDomain.getCategoryId() != null) {
            productEntity.setCategoryId(productDomain.getCategoryId().value());
        }

        return productEntity;
    }
}
