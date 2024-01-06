package com.immobile.immobileapp.web.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.immobile.immobileapp.doa.entities.User;
import com.immobile.immobileapp.services.UserServices;

@Controller
public class AuthController {

    @Autowired
    private UserServices userService;

    @GetMapping("/login")
    public String login(Authentication authentication) {

        return "login";
    }

    @GetMapping("/register")
public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User());
    return "register-user";
}

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "register-user";
        }

         userService.saveUser(user);


        return "redirect:/login";
    }

}
