package org.webappjava.service;

import org.webappjava.model.NewsModel;

import java.util.List;

public interface INewsService {
    List<NewsModel> findByCategoryId(long categoryId);
}
