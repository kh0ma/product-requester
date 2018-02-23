package com.kh0ma.product_requster_service.domain.entity;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.kh0ma.product_requster_service.domain.dao.generic.Identifier;

import java.math.BigDecimal;

/**
 * @author Olexander Khomenko
 */

public class Product implements Identifier<Long> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equal(getId(), product.getId()) &&
                Objects.equal(getName(), product.getName()) &&
                Objects.equal(getPrice(), product.getPrice()) &&
                Objects.equal(getDescription(), product.getDescription()) &&
                Objects.equal(getProductCategoryId(), product.getProductCategoryId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getName(), getPrice(), getDescription(), getProductCategoryId());
    }
}
