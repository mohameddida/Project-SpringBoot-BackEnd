package com.immobile.immobileapp.services;

import com.immobile.immobileapp.doa.entities.Article;

import java.util.List;

public interface ArticlesServices {
    Article getArticle(Long id);

    Article addArticle(Article article);

    Article updateArticle(Article article);

    void deleteArticle(Long id);

    List<Article> getAllArticles();

}
