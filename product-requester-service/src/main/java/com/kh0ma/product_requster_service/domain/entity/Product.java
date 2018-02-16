package com.kh0ma.product_requster_service.domain.entity;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;

/**
 * @author Olexander Khomenko
 */

public class Product {

    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private Long productCategoryId;

    public Product() {
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("price", price)
                .add("description", description)
                .add("productCategoryId", productCategoryId)
                .toString();
    }
}
