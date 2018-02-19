package com.kh0ma.product_requster_service.domain.dao;

import com.kh0ma.product_requster_service.domain.dao.generic.GenericDao;
import com.kh0ma.product_requster_service.domain.entity.Product;
import com.kh0ma.product_requster_service.domain.entity.ProductBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Olexander Khomenko
 */

public class ProductDaoTest extends GenericDaoTest<Product,Long> {

    @Autowired
    private ProductDao dao;

    @Override
    public GenericDao<Product, Long> getDao() {
        return dao;
    }

    @Override
    public List<? extends Product> getTestingData() {
        return Arrays.asList(
                ProductBuilder.aProduct()
                        .withId(1L)
                        .withName("Apple")
                        .withDescription("Some Test Description")
                        .withPrice(BigDecimal.valueOf(12.99))
                        .withProductCategoryId(1L)
                        .build(),
                ProductBuilder.aProduct()
                        .withId(2L)
                        .withName("Orange")
                        .withDescription("Some Test Description")
                        .withPrice(BigDecimal.valueOf(10.87))
                        .withProductCategoryId(1L)
                        .build(),
                ProductBuilder.aProduct()
                        .withId(3L)
                        .withName("Papaya")
                        .withDescription("Some Test Description")
                        .withPrice(BigDecimal.valueOf(39.78))
                        .withProductCategoryId(1L)
                        .build(),
                ProductBuilder.aProduct()
                        .withId(4L)
                        .withName("Potato")
                        .withDescription("Some Test Description")
                        .withPrice(BigDecimal.valueOf(2.99))
                        .withProductCategoryId(2L)
                        .build(),
                ProductBuilder.aProduct()
                        .withId(5L)
                        .withName("Onion")
                        .withDescription("Some Test Description")
                        .withPrice(BigDecimal.valueOf(1.59))
                        .withProductCategoryId(2L)
                        .build(),
                ProductBuilder.aProduct()
                        .withId(6L)
                        .withName("Cucumber")
                        .withDescription("Some Test Description")
                        .withPrice(BigDecimal.valueOf(2.19))
                        .withProductCategoryId(2L)
                        .build()
        );
    }

    @Override
    public Long getId() {
        return 5L;
    }

    @Override
    public Product getObject(Long id) {
        return getTestingData().get(getId().intValue());
    }
}