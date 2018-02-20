package com.kh0ma.product_requster_service.domain.dao.generic;

import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Olexander Khomenko
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class GenericDaoTest<T,PK> {

    private Liquibase liquibase;

    public abstract GenericDao<T,PK> getDao();

    public abstract List<? extends T> getTestingData();

    public abstract <ID extends PK> ID getId();

    public abstract <S extends T, ID extends PK> S getObject(ID id);

    public abstract List<? extends T> getTestingDataWithDeleted();

    public abstract <S extends T, ID extends PK> S getUpdatedObject(S updatingObject);

    @Ignore
    @Test
    public void save() {

    }

    @Test
    public void update() {
        T updatingObject = getDao().findOne(getId());
        T updatedObject = getUpdatedObject(updatingObject);
        T savingObject = getDao().save(updatedObject);
        T savedObject = getDao().findOne(getId());

        assertEquals(updatedObject,savingObject);
        assertEquals(updatedObject,savedObject);
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

    @Autowired
    public void prepareLiquibase(SpringLiquibase springLiquibase) throws Exception {
        Method createLiquibase = springLiquibase
                .getClass()
                .getDeclaredMethod("createLiquibase", Connection.class);
        createLiquibase.setAccessible(true);
        liquibase = (Liquibase) createLiquibase
                .invoke(springLiquibase, springLiquibase.getDataSource().getConnection());
    }

    @Before
    public void updateDb() throws LiquibaseException {
        liquibase.update("test");
    }

    @After
    public void dropDb() throws LiquibaseException {
        liquibase.dropAll();
    }
}