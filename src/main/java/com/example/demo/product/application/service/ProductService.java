package com.example.demo.product.application.service;

import com.example.demo.product.application.entity.Product;
import com.example.demo.product.application.entity.ProductCategory;
import com.example.demo.product.application.model.ProductHeaderModel;
import com.example.demo.product.application.port.in.ProductCreateCommand;
import com.example.demo.product.application.port.in.ProductUseCase;
import com.example.demo.product.application.port.out.persistence.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService implements ProductUseCase {

    private final ProductRepository repository;

    public ProductService(ProductRepository _repository)
    {
        repository = _repository;
    }

    @Override
    public List<ProductHeaderModel> listAll() {

        var product = repository.listAll();

        return ProductHeaderModel.toHeaderModelList(product);
    }

    @Override
    public Optional<Product> getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return repository.findByName(name);
    }

    @Transactional
    @Override
    public Product create(ProductCreateCommand createCmd) {
        // Construct ProductCategory object from createCmd
        var p = new Product();
        p.setName(createCmd.getName());
        p.setCode(createCmd.getCode());
        p.setPrice(createCmd.getPrice());
        p.setCategory(createCmd.getCategory());

        return repository.create(p);
    }
}
