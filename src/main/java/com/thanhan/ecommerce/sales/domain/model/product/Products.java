package com.thanhan.ecommerce.sales.domain.model.product;

import java.util.stream.Stream;

public interface Products {

    Products range(int start, int end);

    Products range(int limit);

    Stream<Product> stream();
}
