package com.antenna.blog.service;

import com.antenna.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    void saveArticle(Article article);
    void updateArticle(Article article);
    Article getArticleByName(String articleName);
    List<Article> listArticels();
}
