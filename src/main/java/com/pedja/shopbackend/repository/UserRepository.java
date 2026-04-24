package com.pedja.shopbackend.repository;

import com.pedja.shopbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}