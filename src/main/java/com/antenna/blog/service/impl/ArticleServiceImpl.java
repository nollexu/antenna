package com.antenna.blog.service.impl;

import com.antenna.blog.entity.Article;
import com.antenna.blog.mapper.ArticleMapper;
import com.antenna.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Override
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }
    @Override
    public Article getArticleByName(String articleName) {
        Article article = articleMapper.getArticleByName(articleName);
        return article;
    }

    @Override
    public List<Article> listArticels() {
        List<Article> articles = articleMapper.listArticles();
        return articles;
    }
}
