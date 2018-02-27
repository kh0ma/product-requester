package com.kh0ma.product_requster_service.domain.entity;

/**
 * @author Olexander Khomenko
 */
public final class ProductCategoryBuilder {
    private Long id;
    private String name;
    private String description;

    private ProductCategoryBuilder() {
    }

    public static ProductCategoryBuilder aProductCategory() {
        return new ProductCategoryBuilder();
    }

    public ProductCategoryBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductCategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductCategoryBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductCategory build() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        productCategory.setName(name);
        productCategory.setDescription(description);
        return productCategory;
    }
}
