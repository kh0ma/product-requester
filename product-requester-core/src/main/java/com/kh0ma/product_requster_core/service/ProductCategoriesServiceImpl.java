package com.kh0ma.product_requster_core.service;

import com.kh0ma.product_requester_db.dao.ProductCategoryDao;
import com.kh0ma.product_requester_domain.domain.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Olexander Khomenko
 */

@Service
public class ProductCategoriesServiceImpl implements ProductCategoriesService {

    @Autowired
    private ProductCategoryDao productCategoryDao;


    @Override
    public ProductCategory findOne(Long id) {
        return productCategoryDao.findOne(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return (List<ProductCategory>) productCategoryDao.findAll();
    }

    @Override
    public ProductCategory save(ProductCategory product) {
        return productCategoryDao.save(product);
    }

    @Override
    public boolean update(Long id, ProductCategory product) {
        product.setId(id);
        ProductCategory saved = productCategoryDao.save(product);

        return saved != null;
    }

    @Override
    public boolean delete(Long id) {
        return productCategoryDao.delete(id);
    }
}
