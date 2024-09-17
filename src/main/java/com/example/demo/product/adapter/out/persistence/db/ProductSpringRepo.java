package com.example.demo.product.adapter.out.persistence.db;

import com.example.demo.product.adapter.out.persistence.db.jpaentity.ProductJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductSpringRepo extends JpaRepository<ProductJpa, Integer> {

    @Query("SELECT pc FROM ProductJpa pc")
    List<ProductJpa> findAll();
}
