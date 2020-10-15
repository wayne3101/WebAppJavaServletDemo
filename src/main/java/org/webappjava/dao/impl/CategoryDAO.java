package org.webappjava.dao.impl;

import org.webappjava.dao.ICategoryDAO;
import org.webappjava.mapper.CategoryMapper;
import org.webappjava.model.CategoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }
}
