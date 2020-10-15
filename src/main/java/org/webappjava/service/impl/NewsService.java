package org.webappjava.service.impl;

import org.webappjava.dao.INewsDAO;
import org.webappjava.model.NewsModel;
import org.webappjava.service.INewsService;

import javax.inject.Inject;
import java.util.List;

public class NewsService implements INewsService {

   @Inject
   private INewsDAO newsDAO;

    @Override
    public List<NewsModel> findByCategoryId(long categoryId) {
        return newsDAO.findByCategoryId(categoryId);
    }
}
