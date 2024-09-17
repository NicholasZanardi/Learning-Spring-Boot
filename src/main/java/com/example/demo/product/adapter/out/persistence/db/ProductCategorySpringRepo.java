/*
 * ProductCategorySpringRepo.java
 *
 * Created on Mar 13, 2024, 15.47
 */
package com.example.demo.product.adapter.out.persistence.db;

import com.example.demo.product.adapter.out.persistence.db.jpaentity.ProductCategoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Irfin A., Nicholas Z.
 * apakah ini bisa digabung dengan RepoImpl ? jadi nya impelment repository extends JPARepository?
 */
public interface ProductCategorySpringRepo extends JpaRepository<ProductCategoryJpa, Integer>
{
    @Query("SELECT pc FROM ProductCategoryJpa pc WHERE pc.isActive = true")
    List<ProductCategoryJpa> findAllActive();

    @Query("SELECT pc FROM ProductCategoryJpa pc WHERE pc.isActive = false")
    List<ProductCategoryJpa> findAllInActive();
}
