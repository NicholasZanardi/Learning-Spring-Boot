/*
 * ProductCategory.java
 *
 * Created on Mar 13, 2024, 14.12
 */
package com.example.demo.product.application.entity;

/**
 * @author Irfin A.
 */
public class ProductCategory
{
    private int systemId;
    private String name;
    private String description;
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
}
