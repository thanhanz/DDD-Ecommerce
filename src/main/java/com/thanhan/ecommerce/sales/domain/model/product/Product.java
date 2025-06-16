package com.thanhan.ecommerce.sales.domain.model.product;

import com.thanhan.ecommerce.common.primitives.Money;
import com.thanhan.ecommerce.sales.domain.model.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.product.valueObject.Description;
import com.thanhan.ecommerce.sales.domain.model.product.valueObject.ProductId;
import com.thanhan.ecommerce.sales.domain.model.product.valueObject.Title;

public interface Product {

    ProductId id();

    Title title();

    Description description();

    Money price();

    void changeTitle(Title title);

    void changeDescription(Description description);

    void changePrice(Money price);

    void putForSale();

    void categorize(CategoryId categoryId);

}
