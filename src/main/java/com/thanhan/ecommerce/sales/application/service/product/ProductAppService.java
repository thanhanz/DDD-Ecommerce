package com.thanhan.ecommerce.sales.application.service.product;

import com.thanhan.ecommerce.sales.application.mapper.response.ProductResponse;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Application Layer: CRUD, Search, Transfer to DTO -> Web
 *
 */
public interface ProductAppService {

    ProductResponse getById(String productId);
    List<ProductResponse> getProductsByCategoryId(String categoryId);
    List<ProductResponse> getProductsByCategoryUri(String uri);
    void create(String title, String description, BigDecimal price);
    void changePrice(String productId, BigDecimal price);
    void updateProduct(String productId, String title, String description);
    void delete(String productId);
    void unpublish(String productId);
}
