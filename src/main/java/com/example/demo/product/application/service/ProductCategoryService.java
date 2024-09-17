/*
 * ProductCategoryService.java
 *
 * Created on Mar 13, 2024, 14.56
 */
package com.example.demo.product.application.service;

import com.example.demo.product.application.entity.ProductCategory;
import com.example.demo.product.application.model.ProductCategoryHeaderModel;
import com.example.demo.product.application.port.in.ProductCategoryCreateCommand;
import com.example.demo.product.application.port.in.ProductCategoryUpdateCommand;
import com.example.demo.product.application.port.in.ProductCategoryUseCase;
import com.example.demo.product.application.port.out.persistence.ProductCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Irfin A., Nicholas Z.
 */
@Service
@Transactional(readOnly = true)
public class ProductCategoryService implements ProductCategoryUseCase
{
    private final ProductCategoryRepository repository;

    public ProductCategoryService(ProductCategoryRepository _repository)
    {
        repository = _repository;
    }

    @Override
    public List<ProductCategoryHeaderModel> listAllActive()
    {
        var productCategories = repository.listAllActive();

        return ProductCategoryHeaderModel.toHeaderModelList(productCategories);
    }

    @Override
    public Optional<ProductCategory> getById(int _id)
    {
        return repository.findById(_id);
    }

    @Transactional
    @Override
    public ProductCategory create(ProductCategoryCreateCommand createCmd)
    {
        // Construct ProductCategory object from createCmd
        var pc = new ProductCategory();
        pc.setName(createCmd.getName());
        pc.setDescription(createCmd.getDescription());
        pc.setActive(true);

        return repository.create(pc);
    }

    @Override
    public ProductCategory update(ProductCategoryUpdateCommand updateCmd)
    {
        // Construct ProductCategory object from updateCmd
        var pc = new ProductCategory();
        pc.setSystemId(updateCmd.getSystemId());
        pc.setName(updateCmd.getNewName());
        pc.setDescription(updateCmd.getNewDescription());
        pc.setActive(true);

        return repository.update(pc);
    }

    @Override
    public Optional<ProductCategory> findByName(String name)
    {
        return repository.findByName(name);
    }
}
