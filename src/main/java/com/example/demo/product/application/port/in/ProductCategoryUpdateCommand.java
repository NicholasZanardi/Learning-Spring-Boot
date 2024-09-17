/*
 * ProductCategoryUpdateModel.java
 *
 * Created on Mar 13, 2024, 14.38
 */
package com.example.demo.product.application.port.in;

import jakarta.annotation.Nonnull;

/**
 * @author Irfin A., Nicholas Z.
 */
public class ProductCategoryUpdateCommand
{
    @Nonnull
    private int systemId;
    @Nonnull
    private String newName;
    private String newDescription;

    public ProductCategoryUpdateCommand(int _systemId, String _newName, String _newDescription)
    {
        systemId = _systemId;
        newName = _newName;
        newDescription = _newDescription;
    }

    public int getSystemId()
    {
        return systemId;
    }

    public String getNewName()
    {
        return newName;
    }

    public String getNewDescription()
    {
        return newDescription;
    }
}
