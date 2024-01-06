package com.immobile.immobileapp.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immobile.immobileapp.doa.entities.Article;
import com.immobile.immobileapp.doa.entities.Reservation;
import com.immobile.immobileapp.doa.entities.User;
import com.immobile.immobileapp.repesitory.ReservationRepository;
import com.immobile.immobileapp.services.ReservationServices;

@Service
public class ReservationServicesImplements implements ReservationServices {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Optional<Reservation> getReservation(Long id) {

        return this.reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> getReservationByStatutReservation(Boolean statutReservation) {
        return this.reservationRepository.findByStatutReservation(statutReservation);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        this.reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return this.reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByClientId(User clientId) {
        return reservationRepository.findByClientId(clientId);
    }

    @Override
    public List<Reservation> getReservationsByArticleId(Article articleId) {
        return reservationRepository.findByArticleId(articleId);
    }
}
