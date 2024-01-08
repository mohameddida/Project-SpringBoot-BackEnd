package com.immobile.immobileapp.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immobile.immobileapp.doa.entities.Article;
import com.immobile.immobileapp.repesitory.ArticlesRepesitory;
import com.immobile.immobileapp.services.ArticlesServices;

import java.util.List;

@Service
public class ArticlesServicesImplements implements ArticlesServices {
    @Autowired
    private ArticlesRepesitory articlesRepesitory;

    @Override
    public Article getArticle(Long id) {
        return articlesRepesitory.findById(id).orElse(null);
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
