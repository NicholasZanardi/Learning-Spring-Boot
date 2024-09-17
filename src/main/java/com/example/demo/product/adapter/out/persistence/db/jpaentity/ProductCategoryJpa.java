/*
 * ProductCategoryJpaEntity.java
 *
 * Created on Mar 13, 2024, 15.49
 */
package com.example.demo.product.adapter.out.persistence.db.jpaentity;

import com.example.demo.product.application.entity.ProductCategory;
import jakarta.persistence.*;

import java.util.List;

/**
 * JPA Entity class of ProductCategory.
 *
 * @author Irfin A.
 */
@Entity
@Table(name = "product_categories")
public class ProductCategoryJpa
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "systemid")
    private int systemId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    public int getSystemId()
    {
        return systemId;
    }

    public void setSystemId(int _systemId)
    {
        systemId = _systemId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String _name)
    {
        name = _name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String _description)
    {
        description = _description;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean _active)
    {
        isActive = _active;
    }

    public static ProductCategoryJpa fromDomain(ProductCategory _pc)
    {
        ProductCategoryJpa jpaEntity = new ProductCategoryJpa();
        jpaEntity.setName(_pc.getName());
        jpaEntity.setDescription(_pc.getDescription());
        jpaEntity.setActive(_pc.isActive());
        System.out.println("CATEGORY "+_pc.getName());

        return jpaEntity;
    }

    public ProductCategory toDomain()
    {
        ProductCategory pc = new ProductCategory();
        pc.setSystemId(systemId);
        pc.setName(name);
        pc.setDescription(description);
        pc.setActive(isActive);

        return pc;
    }

    public static List<ProductCategory> toProductCategoryList(List<ProductCategoryJpa> _jpaEntities)
    {
        return _jpaEntities.stream()
                .map(ProductCategoryJpa::toDomain)
                .toList();
    }
}
