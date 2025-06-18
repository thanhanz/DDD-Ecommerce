package com.thanhan.ecommerce.sales.controller.rest;

import com.thanhan.ecommerce.common.response.ApiResponse;
import com.thanhan.ecommerce.sales.application.service.ProductAppService;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.valueObject.ProductId;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class ProductController {

    private final ProductAppService productAppService;

    @GetMapping("/{productId}")
    public ApiResponse<Product> getById(@PathVariable String productId) {
        return ApiResponse.<Product>builder()
                .data(productAppService.getById(productId))
                .build();
    }

}
