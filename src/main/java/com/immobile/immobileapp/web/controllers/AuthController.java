package com.immobile.immobileapp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/access-denied";
        }
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(
            @ModelAttribute ("user") User user,
            Model model) {
        Long id = userService.saveUser(user);
        String message = "User '" + id + "' saved successfully !";
        model.addAttribute("msg", message);
        return "register-user" + user;
    }

}
