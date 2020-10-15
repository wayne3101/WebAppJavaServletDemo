package org.webappjava.dao.impl;

import org.webappjava.dao.GenericDAO;
import org.webappjava.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jbdc:mysql://localhost:3306/servletdemo";
            String user = "root";
            String password = "daokaka2000";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }

    }

    @Override
    public <T1> List<T1> query(String sql, RowMapper<T1> rowMapper, Object... parameters) {
        List<T1> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                result.add(rowMapper.mapRow(resultSet));
            }
            return result;
        } catch (SQLException e){
            return  null;
        }finally {
            try {
                //close connection, stament and resultSet
                if (connection != null){
                    connection.close();
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            }   catch (SQLException e){
                return null;
            }
        }


    }

    private void setParameter(PreparedStatement statement, Object...parameters) {
        try {
            for (int i = 0; i < parameters.length; i++){
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long){
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String){
                    statement.setString(index, (String) parameter);
                }
            }

        }   catch (SQLException e){
            e.printStackTrace();
        }

    }
}
