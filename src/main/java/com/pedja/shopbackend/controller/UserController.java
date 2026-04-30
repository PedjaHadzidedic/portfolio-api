package com.pedja.shopbackend.controller;

import com.pedja.shopbackend.model.User;
import com.pedja.shopbackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.pedja.shopbackend.dto.UserDTO;
import com.pedja.shopbackend.dto.ApiResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET all users
    @GetMapping
    public ApiResponse<List<UserDTO>> getAllUsers() {
        return new ApiResponse<>(
                true,
                userService.getAllUsers(),
                null
        );
    }

    // GET user by id
    @GetMapping("/{id}")
    public ApiResponse<UserDTO> getUserById(@PathVariable Long id) {
        return new ApiResponse<>(
                true,
                userService.getUserById(id),
                null
        );
    }

    // CREATE user
    @PostMapping
    public ApiResponse<UserDTO> createUser(@Valid @RequestBody User user) {
        return new ApiResponse<>(
                true,
                userService.createUser(user),
                "User created successfully"
        );
    }

    // UPDATE user
    @PutMapping("/{id}")
    public ApiResponse<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        return new ApiResponse<>(
                true,
                userService.updateUser(id, user),
                "User updated successfully"
        );
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return new ApiResponse<>(
                true,
                null,
                "User deleted successfully"
        );
    }
}