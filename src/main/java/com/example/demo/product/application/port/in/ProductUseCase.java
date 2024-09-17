package com.example.demo.product.application.port.in;

import com.example.demo.product.application.entity.Product;
import com.example.demo.product.application.model.ProductHeaderModel;

import java.util.List;
import java.util.Optional;

public interface ProductUseCase {

    /**
     * Mengembalikan semua kategori produk yang aktif.
     * @return
     */
    List<ProductHeaderModel> listAll();

    Optional<Product> getById(int id);

    Optional<Product> findByName(String name);

    Product create(ProductCreateCommand createCmd);

//    Product update(ProductUpdateCommand updateCmd);
}
