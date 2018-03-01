package com.kh0ma.product_requster_core.service;

import com.kh0ma.product_requester_domain.domain.entity.Product;

import java.util.List;

/**
 * @author Olexander Khomenko
 */
public interface ProductService {
    List<Product> findAll(Long productCategoryId);
    Product findOne(Long productCategoryId, Long id);
    Product save(Long productCategoryId, Product product);
    boolean update(Long productCategoryId, Long id, Product product);
    boolean delete(Long productCategoryId, Long id);
}
