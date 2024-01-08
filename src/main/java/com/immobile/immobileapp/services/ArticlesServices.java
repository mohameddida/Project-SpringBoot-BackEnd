package com.immobile.immobileapp.services;

import com.immobile.immobileapp.doa.entities.Article;

public interface ArticlesServices {
    Article getArticle(Long id);

    Article addArticle(Article article);

    Article updateArticle(Article article);

    void deleteArticle(Long id);

    Article getAllArticles();

}
