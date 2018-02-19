package com.kh0ma.product_requster_service.domain.dao;

import java.util.Collection;

/**
 * @author Olexander Khomenko
 *
 * Main interface of DAO
 *
 * @param <T> type of object
 * @param <PK> type of primary key
 */


public interface Dao<T, PK> {

    /**
     * Save object
     *
     * @param <S> is object or its child
     * @return an object contains primary key
     */
    <S extends T> S save(S s);

    /**
     * Find one object by primary key
     *
     * @param pk searched primary key
     * @param <S> is object or its child
     * @return an object contains primary key
     */
    <S extends T> S findOne(PK pk);

    /**
     * Delete object by primary key
     *
     * @param pk searched primary key
     * @return true if delete is successful
     */
    boolean delete(PK pk);

    /**
     * Find all objects
     *
     * @param <S> is object or its child
     * @return collection of objects
     */
    <S extends T> Collection<S> findAll();
}
