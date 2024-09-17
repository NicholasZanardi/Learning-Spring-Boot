package com.example.demo.product.application.port.in;

import com.example.demo.product.application.entity.ProductCategory;
import jakarta.annotation.Nonnull;

import java.math.BigDecimal;

public class ProductCreateCommand {

    @Nonnull
    private String name;
    private String code;
    private BigDecimal price;
    private ProductCategory category;

    public ProductCreateCommand(@Nonnull String _name, String _code, BigDecimal _price, ProductCategory _category) {
        name = _name;
        code = _code;
        price = _price;
        category = _category;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
