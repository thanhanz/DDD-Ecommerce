package com.thanhan.ecommerce.sales.domain.model.catalog.product.service;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.ProductId;

import java.util.List;

/**
 * Domain Layer: tính toán nghiệp vụ (discount, categorize,...)
 *
 */
public interface ProductDomanService {

    Product getProductById(ProductId id);
//    List<Product> getProductsByCategoryId(CategoryId categoryId);

}
