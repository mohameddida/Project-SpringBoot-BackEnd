package com.immobile.immobileapp.doa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dateDeVisite")
    private LocalDateTime dateDeVisite;
    @Column(name = "statutReservation")
    private Boolean statutReservation;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User clientId;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articleId;

}
