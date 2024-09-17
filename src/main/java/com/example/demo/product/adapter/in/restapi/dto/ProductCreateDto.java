package com.example.demo.product.adapter.in.restapi.dto;

import com.example.demo.product.application.entity.ProductCategory;

import java.math.BigDecimal;
//category ? harusnya bisa id nya saja

public record ProductCreateDto(String code, String name, BigDecimal price, ProductCategory category) { }
