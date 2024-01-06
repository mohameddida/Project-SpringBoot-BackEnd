package com.immobile.immobileapp.services;

import java.util.List;
import java.util.Optional;

import com.immobile.immobileapp.doa.entities.Article;
import com.immobile.immobileapp.doa.entities.Reservation;
import com.immobile.immobileapp.doa.entities.User;

public interface ReservationServices {
    Optional<Reservation> getReservation(Long id);

    List<Reservation> getReservationByStatutReservation(Boolean statutReservation);

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(Long id);

    List<Reservation> getAllReservation();

    List<Reservation> getReservationsByClientId(User ClientId);

    List<Reservation> getReservationsByArticleId(Article articleId);
}
