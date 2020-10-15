package org.webappjava.mapper;

import org.webappjava.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        CategoryModel category = new CategoryModel();
        try {
            category.setId(resultSet.getLong("id"));
            category.setName(resultSet.getString("name"));
            category.setCode(resultSet.getString("code"));
            return category;
        } catch (SQLException e) {
            return null;
        }

    }
}
