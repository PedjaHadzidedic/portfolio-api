package com.pedja.shopbackend.service;

import com.pedja.shopbackend.model.User;
import com.pedja.shopbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REGISTER USER
    public User register(User user) {
        return userRepository.save(user);
    }
}