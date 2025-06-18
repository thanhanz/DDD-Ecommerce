package com.thanhan.ecommerce.sales.application.service;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.ProductId;

import java.util.List;

public interface ProductAppService {

    Product getById(String productId);
    List<Product> getProductsByCategoryId(String categoryId);

}
