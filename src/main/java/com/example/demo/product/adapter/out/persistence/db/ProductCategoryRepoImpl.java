/*
 * ProductCategoryRepoImpl.java
 *
 * Created on Mar 13, 2024, 15.42
 */
package com.example.demo.product.adapter.out.persistence.db;

import com.example.demo.product.adapter.out.persistence.db.jpaentity.ProductCategoryJpa;
import com.example.demo.product.application.entity.ProductCategory;
import com.example.demo.product.application.port.out.persistence.ProductCategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Irfin A.
 */
@Repository
public class ProductCategoryRepoImpl implements ProductCategoryRepository
{
    private final ProductCategorySpringRepo springRepo;
    private final ProductCategoryNativeSqlRepoImpl nativeSqlRepo;

    public ProductCategoryRepoImpl(ProductCategorySpringRepo _springRepo, ProductCategoryNativeSqlRepoImpl _nativeSqlRepo)
    {
        springRepo = _springRepo;
        nativeSqlRepo = _nativeSqlRepo;
    }

    @Override
    public ProductCategory create(ProductCategory _pc)
    {
        var jpaEntity = ProductCategoryJpa.fromDomain(_pc);
        springRepo.save(jpaEntity);

        return jpaEntity.toDomain();
    }

    @Override
    public ProductCategory update(ProductCategory _pc)
    {
        var jpaEntity = ProductCategoryJpa.fromDomain(_pc);
        springRepo.save(jpaEntity);

        return jpaEntity.toDomain();
    }

    @Override
    public List<ProductCategory> listAllActive()
    {
        var jpaEntities = springRepo.findAllActive();

        return ProductCategoryJpa.toProductCategoryList(jpaEntities);
    }

    @Override
    public List<ProductCategory> listAllInActive()
    {
        var inactiveEntities = springRepo.findAllInActive();

        return ProductCategoryJpa.toProductCategoryList(inactiveEntities);
    }

    @Override
    public Optional<ProductCategory> findById(int _id)
    {
        var jpaEntity = springRepo.findById(_id);

        return jpaEntity.map(ProductCategoryJpa::toDomain);
    }

    public Optional<ProductCategoryJpa> findJpaById(int _id){
        return springRepo.findById(_id);
    }

    @Override
    public Optional<ProductCategory> findByName(String _name)
    {
        throw new UnsupportedOperationException("Belum diimplementasikan.");
    }
}
