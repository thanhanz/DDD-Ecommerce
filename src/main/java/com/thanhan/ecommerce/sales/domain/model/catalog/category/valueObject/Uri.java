package com.thanhan.ecommerce.sales.domain.model.catalog.category.valueObject;

import lombok.NonNull;

import java.util.regex.Pattern;

public final class Uri {

    private static final String PATTERN = "[a-z]([-a-z0-9]*[a-z0-9])?";

    private final @NonNull String uri;

    public Uri(@NonNull String uri) {
        var uriValue = uri.strip();

        if(uriValue.isBlank()) {
            throw new IllegalArgumentException("URI must not be blank");
        }

        if(!Pattern.matches(PATTERN, uriValue))
            throw new IllegalArgumentException("URI does not match pattern");

        this.uri = uriValue;
    }

    public String value(){
        return uri;
    }

}
