package org.webappjava.dao;

import org.webappjava.model.NewsModel;

import java.util.List;

public interface INewsDAO extends GenericDAO<NewsModel>{
    List<NewsModel> findByCategoryId(long categoryId);
    Long save(NewsModel newsModel);
}
