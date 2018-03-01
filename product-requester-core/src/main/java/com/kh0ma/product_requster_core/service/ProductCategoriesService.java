package com.kh0ma.product_requster_core.service;

import com.kh0ma.product_requester_domain.domain.entity.ProductCategory;

import java.util.List;

/**
 * @author Olexander Khomenko
 */
public interface ProductCategoriesService {
    List<ProductCategory> findAll();
    ProductCategory findOne(Long id);
    ProductCategory save(ProductCategory product);
    boolean update(Long id, ProductCategory product);
    boolean delete(Long id);
}
