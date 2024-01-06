package com.immobile.immobileapp.repesitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobile.immobileapp.doa.entities.Article;
import com.immobile.immobileapp.doa.entities.Reservation;
import com.immobile.immobileapp.doa.entities.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findReservationById(Long id);

    List<Reservation> findByStatutReservation(Boolean StatutReservation);

    List<Reservation> findByClientId(User ClientId);

    List<Reservation> findByArticleId(Article articleId);

}
