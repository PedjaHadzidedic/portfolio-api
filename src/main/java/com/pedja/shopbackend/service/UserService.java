package com.pedja.shopbackend.service;

import com.pedja.shopbackend.model.User;
import com.pedja.shopbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import com.pedja.shopbackend.dto.UserDTO;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET all users
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // GET user by id
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDTO(user);
    }

    // CREATE user
    public UserDTO createUser(User user) {
        User savedUser = userRepository.save(user);
        return mapToDTO(savedUser);
    }

    // UPDATE user
    public UserDTO updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        User savedUser = userRepository.save(user);

        return mapToDTO(savedUser);
    }

    // DELETE user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    // MAP User → UserDTO
    private UserDTO mapToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}