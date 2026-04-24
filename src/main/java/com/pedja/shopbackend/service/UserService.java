package com.pedja.shopbackend.service;

import com.pedja.shopbackend.model.User;
import com.pedja.shopbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // CREATE user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // DELETE user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    public User updateUser(Long id, User updatedUser) {
        // traži postojećeg usera
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // update polja
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        // snimi u bazu
        return userRepository.save(user);
    }
}