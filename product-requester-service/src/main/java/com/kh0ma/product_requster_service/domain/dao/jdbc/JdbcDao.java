package com.kh0ma.product_requster_service.domain.dao.jdbc;

import com.google.common.base.CaseFormat;
import com.kh0ma.product_requster_service.domain.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * @author Olexander Khomenko
 */

public abstract class JdbcDao<T, PK> implements Dao<T, PK> {

    private BeanPropertyRowMapper<T> rowMapper;

    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;


    public JdbcDao() {
    }

    protected abstract String getTableName();

    protected abstract Class<T> getGenericType();

    @Autowired
    public void init(final JdbcTemplate jdbcTemplate,
                     final DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName(getTableName())
                .usingGeneratedKeyColumns("id");
        this.rowMapper = BeanPropertyRowMapper.newInstance(getGenericType());
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends T> S save(S s) {
        return null;
    }

    @Override
    public <S extends T> S findOne(PK pk) {
        return null;
    }

    @Override
    public boolean delete(PK pk) {
        return false;
    }

    @Override
    public <S extends T> Collection<S> findAll() {
        return (Collection<S>) jdbcTemplate.query(String.format("SELECT * FROM %s", getTableName()), rowMapper);
    }

}
