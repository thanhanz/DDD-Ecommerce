package com.thanhan.ecommerce.sales.domain.model.catalog.category;

import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.Title;
import com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject.Uri;

public interface Category {

    CategoryId id();

    Title title();

    Uri uri();

    void changeTitle(Title title);
}
