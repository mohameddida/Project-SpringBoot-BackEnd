package com.immobile.immobileapp.repesitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.immobile.immobileapp.doa.entities.Article;

@Repository
public interface ArticlesRepesitory extends JpaRepository<Article, Long> {
    List<Article> findByNbrPiece(Integer nbrPiece);

    List<Article> findByEmplacement(String emplacement);
}
