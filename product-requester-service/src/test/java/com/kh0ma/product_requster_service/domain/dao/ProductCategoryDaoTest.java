package com.kh0ma.product_requster_service.domain.dao;

import com.google.common.collect.Lists;
import com.kh0ma.product_requster_service.domain.dao.generic.GenericDao;
import com.kh0ma.product_requster_service.domain.dao.generic.GenericDaoTest;
import com.kh0ma.product_requster_service.domain.entity.ProductCategory;
import com.kh0ma.product_requster_service.domain.entity.ProductCategoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Olexander Khomenko
 */
public class ProductCategoryDaoTest extends GenericDaoTest<ProductCategory, Long> {

    @Autowired
    private ProductCategoryDao dao;

    @Override
    public GenericDao<ProductCategory, Long> getDao() {
        return this.dao;
    }

    @Override
    public List<? extends ProductCategory> getTestingData() {
        return Lists.newArrayList(
                ProductCategoryBuilder.aProductCategory()
                        .withId(1L)
                        .withName("Fruits")
                        .withDescription("Some Test Description")
                        .build(),
                ProductCategoryBuilder.aProductCategory()
                        .withId(2L)
                        .withName("Vegetables")
                        .withDescription("Some Test Description")
                        .build());
    }

    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public ProductCategory getObject(Long id) {
        return getTestingData().get(getId().intValue() - 1);
    }

    @Override
    public List<? extends ProductCategory> getTestingDataWithDeleted() {
        List<? extends ProductCategory> testingData = getTestingData();
        testingData.remove(getId().intValue() - 1);
        return testingData;
    }

    @Override
    public ProductCategory getUpdatedObject(ProductCategory updatingObject) {
        updatingObject.setName(updatingObject.getName() + " UPDATED");
        updatingObject.setDescription(updatingObject.getDescription() + " UPDATED");
        return updatingObject;
    }

    @Override
    public ProductCategory getCreatedObject() {
        return ProductCategoryBuilder.aProductCategory()
                .withName("New Product Category")
                .withDescription("New PCategory Description")
                .build();
    }
}