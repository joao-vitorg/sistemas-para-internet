package com.example.backend.linguagem.rest.controllers;

import com.example.backend.linguagem.rest.models.Email;
import com.example.backend.linguagem.rest.services.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/email")
@Tag(name = "Rest", description = "Implementação de REST API")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping()
    public List<Email> getEmail() {
        return emailService.getAllEmails();
    }

    @GetMapping("/{id}")
    public Optional<Email> getEmailById(@PathVariable Long id) {
        return emailService.getEmailById(id);
    }

    @PostMapping()
    public Email createEmail(@RequestBody Email email) {
        return emailService.createEmail(email);
    }

    @PutMapping()
    public Email updateEmail(@RequestBody Email email) {
        return emailService.updateEmail(email);
    }

    @DeleteMapping("/{id}")
    public void deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
    }
}
