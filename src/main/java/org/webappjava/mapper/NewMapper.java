package org.webappjava.mapper;

import org.webappjava.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements RowMapper<NewsModel>{
    @Override
    public NewsModel mapRow(ResultSet resultSet) {
        NewsModel news = new NewsModel();
        try {
            news.setId(resultSet.getLong("id"));
            news.setTitle(resultSet.getString("title"));
            news.setThumbnail(resultSet.getString("thumbnail"));
            news.setShortdescription(resultSet.getString("shortdescription"));
            return news;

        } catch (SQLException e) {
            return null;
        }

    }
}
