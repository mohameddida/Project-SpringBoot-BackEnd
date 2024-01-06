package com.immobile.immobileapp.services;

import java.util.List;
import java.util.Optional;

import com.immobile.immobileapp.doa.entities.Article;

public interface ArticlesServices {
    Optional<Article> getArticle(Long id);

    Article addArticle(Article article);

    Article updateArticle(Article article);

    void deleteArticle(Long id);

    List<Article> getAllArticles();

}
