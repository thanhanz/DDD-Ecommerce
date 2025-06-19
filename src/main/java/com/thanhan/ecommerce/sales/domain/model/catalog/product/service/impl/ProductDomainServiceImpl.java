package com.thanhan.ecommerce.sales.domain.model.catalog.product.service.impl;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.repository.ProductRepository;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.service.ProductDomanService;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDomainServiceImpl implements ProductDomanService {

    private final ProductRepository productRepository;

    @Override
    public Product getProductById(ProductId id) {
        return productRepository.findById(id);
    }

//    @Override
//    public List<Product> getProductsByCategoryId(CategoryId categoryId) {
//        return productRepository.findByCategoryId(categoryId);
//    }
}
