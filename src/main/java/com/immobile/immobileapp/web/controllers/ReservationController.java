package com.immobile.immobileapp.web.controllers;

import com.immobile.immobileapp.doa.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/create")
    public String createArticle(@ModelAttribute("ArticleForm") @Valid ReservationForm reservationForm,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            return "reservation/create";
        }

        Reservation reservation = new Reservation();
        reservation.setDateDeVisite(reservationForm.getDateDeVisite());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();


        reservation.setClientId((User) userDetailsService.loadUserByUsername(currentPrincipalName));
        reservation.setArticleId(articlesServices.getAllArticles());


        reservationServices.addReservation(reservation);

        return "redirect:/articles";
    }
}
