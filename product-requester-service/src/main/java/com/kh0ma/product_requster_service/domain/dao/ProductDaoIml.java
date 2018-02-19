package com.kh0ma.product_requster_service.domain.dao;

import com.kh0ma.product_requster_service.domain.dao.generic.jdbc.JdbcGenericDao;
import com.kh0ma.product_requster_service.domain.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * @author Olexander Khomenko
 */

@Repository
public class ProductDaoIml extends JdbcGenericDao<Product, Long> implements ProductDao {

    private final String tableName = "products";

    private final Class<Product> genericType = Product.class;

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Class<Product> getGenericType() {
        return genericType;
    }
}
