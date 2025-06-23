package com.thanhan.ecommerce.sales.domain.model.catalog.service.impl;

import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.repository.ProductRepository;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.ProductVariant;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.variants.vo.ProductVariantId;
import com.thanhan.ecommerce.sales.domain.model.catalog.service.ProductDomanService;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
