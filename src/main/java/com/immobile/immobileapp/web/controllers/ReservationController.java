package com.immobile.immobileapp.web.controllers;

import com.immobile.immobileapp.doa.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.immobile.immobileapp.doa.entities.Reservation;
import com.immobile.immobileapp.services.ArticlesServices;
import com.immobile.immobileapp.services.ReservationServices;
import com.immobile.immobileapp.services.UserServices;
import com.immobile.immobileapp.web.models.requests.ReservationForm;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationServices reservationServices;
    @Autowired
    UserServices userService;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    ArticlesServices articlesServices;

    @PostMapping("/create/{id}")
    public String createArticle(@PathVariable Long id , @ModelAttribute Reservation reservation ) {




        reservation.setDateDeVisite(reservation.getDateDeVisite());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();



//        reservation.setClientId( userDetailsService.loadUserByUsername(currentPrincipalName));


        reservation.setArticleId(articlesServices.getArticle(id));


        reservationServices.addReservation(reservation);

        return "redirect:/articles";
    }
}
