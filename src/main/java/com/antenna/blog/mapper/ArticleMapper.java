package com.antenna.blog.mapper;

import com.antenna.blog.entity.Article;

import java.util.List;

public interface ArticleMapper {
    void saveArticle(Article article);
    void updateArticle(Article article);
    Article getArticleByName(String articleName);
    List<Article> listArticles();
}
