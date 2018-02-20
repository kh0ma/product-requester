package com.kh0ma.product_requster_service.domain.dao.generic;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.collect.MoreCollectors.onlyElement;

/**
 * @author Olexander Khomenko
 */

public abstract class JdbcGenericDao<T extends Identifier<PK>, PK extends Serializable> implements GenericDao<T, PK> {

    private BeanPropertyRowMapper<T> rowMapper;

    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public JdbcGenericDao() {
    }

    protected abstract String getTableName();

    protected abstract Class<T> getGenericType();

    protected abstract PK fromNumberToPk(Number id);

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
        final BeanPropertySqlParameterSource map = new BeanPropertySqlParameterSource(s);
        if (s.getId() == null) {
            Number number = jdbcInsert.executeAndReturnKey(map);
            s.setId(fromNumberToPk(number));
            return s;
        } else {
            MapSqlParameterSource paramsMap = getParamsMap(s, map);
            int updatedRows = namedParameterJdbcTemplate.update(getUpdateSql(paramsMap), paramsMap);
            if (updatedRows == 0) {
                return null;
            }
        }
        return s;
    }

    @Override
    public <S extends T> S findOne(PK pk) {
        List<T> query = jdbcTemplate.query(String.format("SELECT * FROM %s WHERE id=?", getTableName()), rowMapper, pk);

        return (S) query.stream().collect(onlyElement());
    }

    @Override
    public boolean delete(PK pk) {
        return jdbcTemplate.update(String.format("DELETE FROM %s WHERE id=?", getTableName()), pk) != 0;
    }

    @Override
    public <S extends T> Collection<S> findAll() {
        return (Collection<S>) jdbcTemplate.query(String.format("SELECT * FROM %s", getTableName()), rowMapper);
    }


    private String toLowerCase(String camelCase) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, camelCase);
    }

    private Object objectFromField(String field, BeanWrapperImpl beanWrapper) {
        return beanWrapper.getPropertyValue(field);
    }

    private <S extends T> MapSqlParameterSource getParamsMap(final S entity, final BeanPropertySqlParameterSource map) {
        final MapSqlParameterSource params = new MapSqlParameterSource();

        final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(entity);

        ArrayList<String> fields = Lists.newArrayList(map.getReadablePropertyNames());
        fields.remove("class");

        fields.forEach(field -> params.addValue(toLowerCase(field), objectFromField(field, beanWrapper)));

        return params;
    }

    private String getUpdateSql(MapSqlParameterSource params) {
        Set<String> fields = params.getValues().keySet();
        String collectedFields = fields.stream()
                .filter(field -> !field.equalsIgnoreCase("id"))
                .map(field -> String.format("%s=:%s", field, field))
                .collect(Collectors.joining(", "));
        return String.format("UPDATE %s SET %s WHERE id=%s",
                getTableName(),
                collectedFields,
                params.getValue("id"));
    }
}
