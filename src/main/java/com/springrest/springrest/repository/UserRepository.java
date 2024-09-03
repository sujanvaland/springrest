package com.springrest.springrest.repository;
import com.springrest.springrest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find a user by username
    User findByUsername(String Username);
}
