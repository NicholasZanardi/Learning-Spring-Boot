/*
 * ProductCategoryCreateCommand.java
 *
 * Created on Mar 13, 2024, 14.32
 */
package com.example.demo.product.application.port.in;

import jakarta.annotation.Nonnull;

/**
 * Class yang menampung data yang diperlukan untuk (perintah) menciptakan kategori produk.
 *
 * @author Irfin A., Nicholas Z.
 */
public class ProductCategoryCreateCommand
{
    @Nonnull
    private String name;
    private String description;

    public ProductCategoryCreateCommand(String _name, String _description)
    {
        name = _name;
        description = _description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
}
