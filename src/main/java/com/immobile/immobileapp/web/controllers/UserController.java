package com.immobile.immobileapp.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immobile.immobileapp.doa.entities.User;
import com.immobile.immobileapp.repesitory.UserRepesitory;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepesitory userRepo;

    @GetMapping("/findAllUsers")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
