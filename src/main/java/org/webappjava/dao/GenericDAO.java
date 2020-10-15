package org.webappjava.dao;

import org.webappjava.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object...parameters);
}
