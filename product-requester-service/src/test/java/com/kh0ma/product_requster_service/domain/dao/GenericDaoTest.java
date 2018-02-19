package com.kh0ma.product_requster_service.domain.dao;

import com.kh0ma.product_requster_service.domain.dao.generic.GenericDao;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Olexander Khomenko
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class GenericDaoTest<T,PK> {

    public abstract GenericDao<T,PK> getDao();

    public abstract Collection<? extends T> getTestingData();

    @Ignore
    @Test
    public void save() {
    }

    @Ignore
    @Test
    public void findOne() {
    }

    @Ignore
    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
        Collection<? extends T> all = getDao().findAll();

        assertArrayEquals(getTestingData().toArray(),all.toArray());
    }
}