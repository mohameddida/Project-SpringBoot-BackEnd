package com.immobile.immobileapp.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immobile.immobileapp.doa.entities.Article;
import com.immobile.immobileapp.repesitory.ArticlesRepesitory;
import com.immobile.immobileapp.services.ArticlesServices;

@Service
public class ArticlesServicesImplements implements ArticlesServices {
    @Autowired
    private ArticlesRepesitory articlesRepesitory;

    @Override
    public Optional<Article> getArticle(Long id) {
        return this.articlesRepesitory.findById(id);
    }

    @Override
    public Article addArticle(Article article) {
        return articlesRepesitory.save(article);
    };

    @Override
    public Article updateArticle(Article article) {
        return articlesRepesitory.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articlesRepesitory.deleteById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articlesRepesitory.findAll();
    }

 
}
