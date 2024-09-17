package com.example.demo.product.adapter.in.restapi.dto;

import com.example.demo.product.application.entity.Product;

import java.math.BigDecimal;

public record ProductDto (int systemId , String code, String name, BigDecimal price , int categoryId , String categoryName){
    public static ProductDto from(Product p) {
        return new ProductDto(
                p.getSystemId(),
                p.getCode(),
                p.getName(),
                p.getPrice(),
                p.getCategory().getSystemId(),
                p.getCategory().getName()
        );
    }

}
