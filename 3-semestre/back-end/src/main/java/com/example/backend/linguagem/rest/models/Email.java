package com.example.backend.linguagem.rest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "from_email")
    private String to;
    @Column(name = "to_email")
    private String subject;
    private String body;
    private String attachment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id) && Objects.equals(to, email.to) && Objects.equals(subject, email.subject) && Objects.equals(body, email.body) && Objects.equals(attachment, email.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, to, subject, body, attachment);
    }
}
