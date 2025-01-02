package com.a99.repository;

import com.a99.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find a user by their username (for login authentication)
    Optional<User> findByUsername(String username);
}
