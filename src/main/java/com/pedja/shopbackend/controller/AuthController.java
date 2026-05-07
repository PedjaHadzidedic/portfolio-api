package com.pedja.shopbackend.controller;

import com.pedja.shopbackend.model.User;
import com.pedja.shopbackend.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // REGISTER USER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }
}