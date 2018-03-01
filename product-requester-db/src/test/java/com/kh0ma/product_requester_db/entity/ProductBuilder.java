package com.kh0ma.product_requester_db.entity;

import com.kh0ma.product_requester_domain.domain.entity.Product;

import java.math.BigDecimal;

/**
 * @author Olexander Khomenko
 */
public final class ProductBuilder {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Long productCategoryId;

    private ProductBuilder() {
    }

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public ProductBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder withProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
        return this;
    }

    public Product build() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setProductCategoryId(productCategoryId);
        return product;
    }
}
