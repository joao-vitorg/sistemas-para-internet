package com.example.backend.linguagem.rest.repository;

import com.example.backend.linguagem.rest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
