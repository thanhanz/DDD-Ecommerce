package com.thanhan.ecommerce.sales.application.service.product.impl;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.application.mapper.response.ProductResponse;
import com.thanhan.ecommerce.sales.application.service.product.ProductAppService;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.vo.Uri;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.Description;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.ProductId;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.vo.Title;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.repository.ProductRepository;
import com.thanhan.ecommerce.sales.domain.model.catalog.service.ProductDomanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductAppServiceImpl implements ProductAppService {

    private final ProductDomanService productDomanService;
    private final ProductRepository productRepository;

    @Override
    public ProductResponse getById(String productId) {
        return ProductResponse.from(productRepository.findById(new ProductId(productId)));
    }

    @Override
    public List<ProductResponse> getProductsByCategoryId(String categoryId) {
        return List.of();
    }

    @Override
    public List<ProductResponse> getProductsByCategoryUri(String uri) {
        return productRepository.findByUri(new Uri(uri)).stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public void create(String title, String description, BigDecimal price) {
        Product newProduct = Product.create(new Title(title), new Description(description), new Money(price));
        productRepository.save(newProduct);
    }

//    @Override
//    public void changePrice(String productId, BigDecimal price) {
//        Product product = productRepository.findById(new ProductId(productId));
//        product.changePrice(new Money(price));
//        productRepository.save(product);
//    }

    @Override
    public void updateProduct(String productId, String title, String description) {
        Product product = productRepository.findById(new ProductId(productId));
        product.changeTitle(new Title(title));
        product.changeDescription(new Description(description));
        productRepository.save(product);
    }

    @Override
    public void delete(String productId) {
        Product product = productRepository.findById(new ProductId(productId));
        productRepository.delete(product);
    }

    @Override
    public void unpublish(String productId) {
        //Update Status product
    }
}
