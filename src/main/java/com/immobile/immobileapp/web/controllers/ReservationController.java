package com.immobile.immobileapp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    ArticlesServices articlesServices;

    @PostMapping("/create")
    public String createArticle(@ModelAttribute("ArticleForm") @Valid ReservationForm reservationForm,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("reservation", reservationServices.getAllReservation());
            return "reservation/create";

        }

        // Create a new product object from the request body
        Reservation reservation = new Reservation();
        reservation.setDateDeVisite(reservationForm.getDateDeVisite());
        model.addAttribute("reservationForm", reservationForm);
        model.addAttribute("clientId", userService.findAllUsers());
        model.addAttribute("articleId", articlesServices.getAllArticles());

        return "redirect:/articles";
    }
}
