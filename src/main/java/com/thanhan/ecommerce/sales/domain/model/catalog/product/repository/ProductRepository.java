package com.thanhan.ecommerce.sales.domain.model.catalog.product.repository;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.Uri;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;

import java.util.List;

public interface ProductRepository {
    Product findById(ProductId id);
//    List<Product> findByCategoryId(CategoryId categoryId);
    void save(Product product);
    void delete(Product product);
    List<Product> findByUri(Uri categoryUri);
}
