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

    // GET user by id
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // CREATE user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // UPDATE user
    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        return userRepository.save(user);
    }

    // DELETE user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}