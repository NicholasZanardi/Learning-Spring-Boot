package com.example.demo.product.application.model;

import com.example.demo.product.application.entity.Product;
import com.example.demo.product.application.entity.ProductCategory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ProductHeaderModel {

    private int systemId;
    private String code;
    private String name;
    private BigDecimal price;
    private int categoryId;
    private String categoryName;

    public ProductHeaderModel(){

    }

    public ProductHeaderModel(int _systemId, String _code, String _name, BigDecimal _price , int _categoryId , String _categoryName) {
        systemId = _systemId;
        code = _code;
        name = _name;
        price = _price;
        categoryId = _categoryId;
        categoryName = _categoryName;

    }

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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public static List<ProductHeaderModel> toHeaderModelList(List<Product> _product)
    {
        var retval = new LinkedList<ProductHeaderModel>();

        ProductHeaderModel headerModel;
        for (var pc : _product) {
            headerModel = new ProductHeaderModel();
            headerModel.setSystemId(pc.getSystemId());
            headerModel.setName(pc.getName());
            headerModel.setCode(pc.getCode());
            headerModel.setPrice(pc.getPrice());
            headerModel.setCategoryId(pc.getCategory().getSystemId());
            headerModel.setCategoryName(pc.getCategory().getName());

            retval.add(headerModel);
        }

        return retval;
    }
}
