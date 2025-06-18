package com.thanhan.ecommerce.sales.application.service.impl;

import com.thanhan.ecommerce.sales.application.service.ProductAppService;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.ProductId;
import com.thanhan.ecommerce.sales.domain.service.ProductDomanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductAppServiceImpl implements ProductAppService {

    private final ProductDomanService productDomanService;

    @Override
    public Product getById(String productId) {
        return productDomanService.getProductById(new ProductId(productId));
    }

    @Override
    public List<Product> getProductsByCategoryId(String categoryId) {
        return productDomanService.getProductsByCategoryId(new CategoryId(categoryId));
    }
}
