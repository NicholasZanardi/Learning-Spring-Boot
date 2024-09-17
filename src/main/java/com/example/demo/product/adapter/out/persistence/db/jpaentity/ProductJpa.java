package com.example.demo.product.adapter.out.persistence.db.jpaentity;

import com.example.demo.product.application.entity.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "systemid")
    private int systemId;
    //unique true tidak perlu
    @Column(name = "code", unique = true)
    private String code;
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "price")
    private BigDecimal price;
    //referencedColumnName tidak wajib

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productcategory_id", nullable = false)
    private ProductCategoryJpa category;

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategoryJpa getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryJpa category) {
        this.category = category;
    }

    public static ProductJpa fromDomain(Product _p)
    {
        ProductJpa jpaEntity = new ProductJpa();
        jpaEntity.setName(_p.getName());
        jpaEntity.setCode(_p.getCode());
        jpaEntity.setPrice(_p.getPrice());
        ProductCategoryJpa jpaCategoryEntity = ProductCategoryJpa.fromDomain(_p.getCategory());
        jpaEntity.setCategory(jpaCategoryEntity);

        return jpaEntity;
    }

    public Product toDomain()
    {
        Product p = new Product();
        p.setSystemId(systemId);
        p.setName(name);
        p.setCode(code);
        p.setPrice(price);
        p.setCategory(category.toDomain());

        return p;
    }

    public static List<Product> toProductList(List<ProductJpa> _jpaEntities)
    {
        return _jpaEntities.stream()
                .map(ProductJpa::toDomain)
                .toList();
    }
}
