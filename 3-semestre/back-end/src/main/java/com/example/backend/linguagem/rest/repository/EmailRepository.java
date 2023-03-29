package com.example.backend.linguagem.rest.repository;

import com.example.backend.linguagem.rest.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
