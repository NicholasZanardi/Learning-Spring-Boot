/*
 * ProductCategoryHeaderModel.java
 *
 * Created on Mar 13, 2024, 14.19
 */
package com.example.demo.product.application.model;

import com.example.demo.product.application.entity.ProductCategory;

import java.util.LinkedList;
import java.util.List;

/**
 * Class ini digunakan untuk menampilkan data kategori produk dalam bentuk ringkas yang biasanya
 * digunakan untuk menampilkan daftar kategori produk.
 *
 * @author Irfin A., Nicholas Z.
 */
public class ProductCategoryHeaderModel
{
    private int systemId;
    private String name;

    public ProductCategoryHeaderModel()
    {
    }

    public ProductCategoryHeaderModel(int _systemId, String _name)
    {
        systemId = _systemId;
        name = _name;
    }

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

    public static List<ProductCategoryHeaderModel> toHeaderModelList(List<ProductCategory> _productCategories)
    {
        var retval = new LinkedList<ProductCategoryHeaderModel>();

        ProductCategoryHeaderModel headerModel;
        for (var pc : _productCategories) {
            headerModel = new ProductCategoryHeaderModel();
            headerModel.setSystemId(pc.getSystemId());
            headerModel.setName(pc.getName());

            retval.add(headerModel);
        }

        return retval;
    }
}
