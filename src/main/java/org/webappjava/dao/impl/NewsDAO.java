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

    @Override
    public Long save(NewsModel newsModel) {
        ResultSet resultSet = null;
        Long id = null;
        Connection connection = null;
        PreparedStatement statement =  null;
        try {
            String sql = "INSERT INTO news (title, thumbnail, shortdescription, categoryid) VALUES(?, ?, ?, ?)";
             connection = getConnection();
            connection.setAutoCommit(false);
             statement= connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, newsModel.getTitle());
            statement.setString(2, newsModel.getThumbnail());
            statement.setString(3, newsModel.getShortdescription());
            statement.setLong(4, newsModel.getCategoryId());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e){
            if (connection != null){
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            return null;
        } finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
                if (statement != null){
                    statement.close();
                }
            } catch (SQLException e){
                return null;
            }
        }
    }
}
