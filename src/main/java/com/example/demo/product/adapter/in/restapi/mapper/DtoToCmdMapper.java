/*
 * DtoToCmdMapper.java
 *
 * Created on Mar 14, 2024, 11.22
 */
package com.example.demo.product.adapter.in.restapi.mapper;

import com.example.demo.product.adapter.in.restapi.dto.ProductCategoryCreateDto;
import com.example.demo.product.adapter.in.restapi.dto.ProductCategoryUpdateDto;
import com.example.demo.product.adapter.in.restapi.dto.ProductCreateDto;
import com.example.demo.product.application.port.in.ProductCategoryCreateCommand;
import com.example.demo.product.application.port.in.ProductCategoryUpdateCommand;
import com.example.demo.product.application.port.in.ProductCreateCommand;

/**
 * Convert from DTO to Command classes related to ProductCategory.
 *
 * @author Irfin A.
 */
public class DtoToCmdMapper
{
    public static ProductCategoryCreateCommand fromCreateDto(ProductCategoryCreateDto _dto)
    {
        return new ProductCategoryCreateCommand(_dto.name(), _dto.description());
    }

    public static ProductCategoryUpdateCommand fromUpdateDto(ProductCategoryUpdateDto _dto)
    {
        return new ProductCategoryUpdateCommand(_dto.systemId(), _dto.newName(), _dto.newDescription());
    }

    public static ProductCreateCommand fromProductCreateDto(ProductCreateDto _dto)
    {
        return new ProductCreateCommand(_dto.name(), _dto.code() , _dto.price() , _dto.category());
    }
}
