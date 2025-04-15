package com.bodkasoft.goodscatalogclient.api.model;

import java.util.List;

public class Category {
    private Integer id;
    private String name;
    private String description;
    private Integer parentId;
    private List<Category> subCategories;
    private List<Product> products;

    public Category(String name, String description, Integer parentId, List<Category> subCategories, List<Product> products) {
        this.name = name;
        this.description = description;
        this.parentId = parentId;
        this.subCategories = subCategories;
        this.products = products;
    }

    public Category() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
