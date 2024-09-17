package com.example.demo.product.application.port.out.persistence;

import com.example.demo.product.application.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> listAll();
    Optional<Product> findById(int _id);
    Optional<Product> findByName(String _name);
    Product create(Product _p);
}
