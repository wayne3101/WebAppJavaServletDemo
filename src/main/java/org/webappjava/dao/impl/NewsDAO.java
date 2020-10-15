package org.webappjava.dao.impl;

import org.webappjava.dao.INewsDAO;
import org.webappjava.mapper.NewMapper;
import org.webappjava.model.CategoryModel;
import org.webappjava.model.NewsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {



    @Override
    public List<NewsModel> findByCategoryId(long categoryId) {
        String sql = "SELECT * FROM news WHERE category_id = ?";
        return query(sql, new NewMapper(), categoryId);
    }
}
