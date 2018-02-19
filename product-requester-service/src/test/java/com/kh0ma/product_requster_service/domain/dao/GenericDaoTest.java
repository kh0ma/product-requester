package com.kh0ma.product_requster_service.domain.dao;

import com.kh0ma.product_requster_service.domain.dao.generic.GenericDao;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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

    public abstract List<? extends T> getTestingData();

    public abstract <ID extends PK> ID getId();

    public abstract <S extends T, ID extends PK> S getObject(ID id);

    @Ignore
    @Test
    public void save() {
    }

    @Test
    public void findOne() {
        T object = getDao().findOne(getId());

        assertEquals(getObject(getId()),object);
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