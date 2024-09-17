/*
 * ProductCategoryRepository.java
 *
 * Created on Mar 13, 2024, 15.34
 */
package com.example.demo.product.application.port.out.persistence;

import com.example.demo.product.application.entity.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * Deklarasi operasi2 repository objek ProductCategory.
 *
 * @author Irfin A.
 */
public interface ProductCategoryRepository
{
    ProductCategory create(ProductCategory _pc);
    ProductCategory update(ProductCategory _pc);
    List<ProductCategory> listAllActive();
    List<ProductCategory> listAllInActive();
    Optional<ProductCategory> findById(int _id);
    Optional<ProductCategory> findByName(String _name);
}
