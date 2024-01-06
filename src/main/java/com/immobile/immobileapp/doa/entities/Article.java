package com.immobile.immobileapp.doa.entities;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "prix")
    private Double price;
    @Column(name = "emplacement")
    private String emplacement;
    @Column(name = "nbrPiece")
    private Integer nbrPiece;
    @Column(name = "description")
    private String description;
    @Column(name = "disponible")
    @Value("${some.key:false}")
    private Boolean disponible;
    @Column(name = "imageMain")
    private String imageMain;
    @Column(name = "imageOne")
    private String imageOne;
    @Column(name = "imageTwo")
    private String imageTwo;
    @Column(name = "imageThree")
    private String imageThree;

}
