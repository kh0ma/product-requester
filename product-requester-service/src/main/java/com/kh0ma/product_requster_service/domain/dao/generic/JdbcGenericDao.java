package com.kh0ma.product_requster_service.domain.dao.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import static com.google.common.collect.MoreCollectors.onlyElement;


import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

/**
 * @author Olexander Khomenko
 */

public abstract class JdbcGenericDao<T, PK> implements GenericDao<T, PK> {

    private BeanPropertyRowMapper<T> rowMapper;

    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;


    public JdbcGenericDao() {
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
        List<T> query = jdbcTemplate.query(String.format("SELECT * FROM %s WHERE id=?", getTableName()), rowMapper, pk);

        return (S) query.stream().collect(onlyElement());
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
