package com.kh0ma.product_requster_service.domain.dao;

import com.kh0ma.product_requster_service.domain.dao.generic.JdbcGenericDao;
import com.kh0ma.product_requster_service.domain.entity.ProductCategory;
import org.springframework.stereotype.Repository;

/**
 * @author Olexander Khomenko
 */

@Repository
public class ProductCategoryDaoImpl
        extends JdbcGenericDao<ProductCategory, Long>
        implements ProductCategoryDao {
    @Override
    protected String getTableName() {
        return "product_categories";
    }

    @Override
    protected Class<ProductCategory> getGenericType() {
        return ProductCategory.class;
    }

    @Override
    protected Long fromNumberToPk(final Number id) {
        return Long.valueOf(id.toString());
    }
}
