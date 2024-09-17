package com.example.demo.product.adapter.out.persistence.db;

import com.example.demo.product.adapter.out.persistence.db.jpaentity.ProductJpa;
import com.example.demo.product.application.entity.Product;
import com.example.demo.product.application.port.out.persistence.ProductCategoryRepository;
import com.example.demo.product.application.port.out.persistence.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepoImpl  implements ProductRepository {

    private final ProductSpringRepo springRepo;

    private final ProductCategoryRepoImpl categoryRepo;

    public ProductRepoImpl(ProductSpringRepo _springRepo , ProductCategoryRepoImpl _categoryRepo) {
        springRepo = _springRepo;
        categoryRepo = _categoryRepo;
    }

    @Override
    public List<Product> listAll() {

        var jpaEntities = springRepo.findAll();

        return ProductJpa.toProductList(jpaEntities);
    }

    @Override
    public Optional<Product> findById(int _id) {
        var jpaEntity = springRepo.findById(_id);

        return jpaEntity.map(ProductJpa::toDomain);
    }

    @Override
    public Optional<Product> findByName(String _name) {
        throw new UnsupportedOperationException("Belum diimplementasikan.");
    }

    @Override
    public Product create(Product _p) {
        var jpaEntity = ProductJpa.fromDomain(_p);
        var optCategory = categoryRepo.findJpaById(_p.getCategory().getSystemId());
        if(optCategory.isEmpty()){
            throw new RuntimeException("Product Category Not Found!");
        }
        jpaEntity.setCategory(optCategory.get());
        springRepo.save(jpaEntity);

        return jpaEntity.toDomain();
    }

}
