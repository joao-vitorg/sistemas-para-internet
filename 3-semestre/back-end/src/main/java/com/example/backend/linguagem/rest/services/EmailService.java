package com.example.backend.linguagem.rest.services;

import com.example.backend.linguagem.rest.models.Email;
import com.example.backend.linguagem.rest.repository.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    private final EmailRepository EmailRepository;

    public EmailService(EmailRepository EmailRepository) {
        this.EmailRepository = EmailRepository;
    }

    public List<Email> getAllEmails() {
        return EmailRepository.findAll();
    }

    public Optional<Email> getEmailById(Long id) {
        return EmailRepository.findById(id);
    }

    public Email createEmail(Email email) {
        return EmailRepository.save(email);
    }

    public Email updateEmail(Email email) {
        return EmailRepository.save(email);
    }

    public void deleteEmail(Long id) {
        EmailRepository.deleteById(id);
    }
}
