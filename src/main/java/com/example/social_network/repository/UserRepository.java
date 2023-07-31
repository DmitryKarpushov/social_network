package com.example.social_network.repository;

import com.example.social_network.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Дмитрий Карпушов 29.07.2023
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByLogin(String login);

    Optional<User> findByEmail(String email);
}
