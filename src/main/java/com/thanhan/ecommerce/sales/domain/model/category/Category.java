package com.thanhan.ecommerce.sales.domain.model.category;

import com.thanhan.ecommerce.sales.domain.model.category.valueObject.CategoryId;
import com.thanhan.ecommerce.sales.domain.model.category.valueObject.Title;
import com.thanhan.ecommerce.sales.domain.model.category.valueObject.Uri;

public interface Category {

    CategoryId id();

    Title title();

    Uri uri();

    void changeTitle(Title title);
}
