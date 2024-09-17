/*
 * ProductCategoryUseCase.java
 *
 * Created on Mar 13, 2024, 14.15
 */
package com.example.demo.product.application.port.in;

import com.example.demo.product.application.entity.ProductCategory;
import com.example.demo.product.application.model.ProductCategoryHeaderModel;

import java.util.List;
import java.util.Optional;

/**
 * @author Irfin A., Nicholas Z.
 */
public interface ProductCategoryUseCase
{
    /**
     * Mengembalikan semua kategori produk yang aktif.
     * @return
     */
    List<ProductCategoryHeaderModel> listAllActive();

    Optional<ProductCategory> getById(int id);

    ProductCategory create(ProductCategoryCreateCommand createCmd);

    ProductCategory update(ProductCategoryUpdateCommand updateCmd);

    Optional<ProductCategory> findByName(String name);
}
