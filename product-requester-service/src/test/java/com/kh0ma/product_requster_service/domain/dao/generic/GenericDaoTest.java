package com.kh0ma.product_requster_service.domain.dao.generic;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    public abstract List<? extends T> getTestingDataWithDeleted();

    @Ignore
    @Test
    public void save() {
    }

    @Test
    public void findOne() {
        T object = getDao().findOne(getId());

        assertEquals(getObject(getId()),object);
    }

    @Test
    public void delete() {
        boolean isDeleted = getDao().delete(getId());

        Collection<? extends T> all = getDao().findAll();

        assertTrue(isDeleted);
        assertArrayEquals(getTestingDataWithDeleted().toArray(),all.toArray());
    }

    @Test
    public void findAll() {
        Collection<? extends T> all = getDao().findAll();

        assertArrayEquals(getTestingData().toArray(),all.toArray());
    }
}