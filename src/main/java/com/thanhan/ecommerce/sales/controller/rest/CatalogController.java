package com.thanhan.ecommerce.sales.controller.rest;

import com.thanhan.ecommerce.common.response.ApiResponse;
import com.thanhan.ecommerce.sales.application.mapper.response.CategoryResponse;
import com.thanhan.ecommerce.sales.application.mapper.response.ProductResponse;
import com.thanhan.ecommerce.sales.application.service.category.CategoryAppService;
import com.thanhan.ecommerce.sales.application.service.product.ProductAppService;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.Category;
import com.thanhan.ecommerce.sales.domain.model.catalog.product.Product;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final ProductAppService productAppService;
    private final CategoryAppService categoryAppService;
    private final RestClient.Builder builder;

    @GetMapping("/products/{productId}")
    public ApiResponse<ProductResponse> getById(@PathVariable String productId) {
        return ApiResponse.<ProductResponse>builder()
                .data(productAppService.getById(productId))
                .build();
    }

    @GetMapping("/categories")
    public ApiResponse<List<CategoryResponse>> getCategories() {
        return ApiResponse.<List<CategoryResponse>>builder()
                .data(categoryAppService.getCategories())
                .build();
    }

    @GetMapping("/categories/{categoryUri}")
    public ApiResponse<List<ProductResponse>> getProductsByCategoryUri(@PathVariable @NonNull String categoryUri) {
        return ApiResponse.<List<ProductResponse>>builder()
                .data(productAppService.getProductsByCategoryUri(categoryUri))
                .build();
    }



}
