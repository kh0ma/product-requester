package com.kh0ma.product_requster_service.domain.entity;

import com.google.common.base.MoreObjects;
import com.kh0ma.product_requster_service.domain.dao.generic.Identifier;

/**
 * @author Olexander Khomenko
 */
public class ProductCategory implements Identifier<Long> {

    private Long id;

    private String name;

    private String description;

    public ProductCategory() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("description", description)
                .toString();
    }
}
