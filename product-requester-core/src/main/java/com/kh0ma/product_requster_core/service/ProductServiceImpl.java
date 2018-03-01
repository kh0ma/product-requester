package com.kh0ma.product_requster_core.service;

import com.kh0ma.product_requester_db.dao.ProductDao;
import com.kh0ma.product_requester_domain.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olexander Khomenko
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(Long productCategoryId) {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product findOne(Long productCategoryId, Long id) {
        return productDao.findOne(productCategoryId);
    }

    @Override
    public Product save(Long productCategoryId, Product product) {
        product.setProductCategoryId(productCategoryId);
        return productDao.save(product);
    }

    @Override
    public boolean update(Long productCategoryId, Long id, Product product) {
        Product saved = productDao.save(product);
        saved.setId(id);
        return saved != null;
    }

    @Override
    public boolean delete(Long productCategoryId, Long id) {
        return productDao.delete(id);
    }
}
