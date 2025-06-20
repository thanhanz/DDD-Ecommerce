package com.thanhan.ecommerce.sales.domain.model.catalog.service;

import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;

/**
 * Domain Layer: tính toán nghiệp vụ (discount, categorize,...)
 *
 */
public interface ProductDomanService {

    Product getProductById(ProductId id);
//    List<Product> getProductsByCategoryId(CategoryId categoryId);

}
