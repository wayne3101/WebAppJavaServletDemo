package org.webappjava.service.impl;

import org.webappjava.dao.ICategoryDAO;

import org.webappjava.model.CategoryModel;
import org.webappjava.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() {

        return categoryDAO.findAll();
    }
}
