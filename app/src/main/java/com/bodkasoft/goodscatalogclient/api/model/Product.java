package com.bodkasoft.goodscatalogclient.api.model;

import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private List<String> imagesUrls;
    private Integer categoryId;


    public Product(Long id, String name, String description, Double price, List<String> imagesUrls, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagesUrls = imagesUrls;
        this.categoryId = categoryId;
    }

    public Product() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
