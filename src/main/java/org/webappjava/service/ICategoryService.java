package org.webappjava.service;

import org.webappjava.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
}
