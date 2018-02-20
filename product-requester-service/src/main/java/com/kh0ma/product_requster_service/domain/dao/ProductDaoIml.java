package com.kh0ma.product_requster_service.domain.dao;

import com.kh0ma.product_requster_service.domain.dao.generic.JdbcGenericDao;
import com.kh0ma.product_requster_service.domain.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * @author Olexander Khomenko
 */

@Repository
public class ProductDaoIml
        extends JdbcGenericDao<Product, Long>
        implements ProductDao {

    private static final String TABLE_NAME = "products";

    private static final Class<Product> GENERIC_TYPE = Product.class;

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Class<Product> getGenericType() {
        return GENERIC_TYPE;
    }

    @Override
    protected Long fromNumberToPk(final Number id) {
        return Long.valueOf(id.toString());
    }
}
