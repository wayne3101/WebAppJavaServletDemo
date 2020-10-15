package org.webappjava.dao;

import org.webappjava.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
    List<CategoryModel> findAll();
}
