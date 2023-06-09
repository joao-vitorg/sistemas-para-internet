package com.example.testes.linguagem.cliente.repositories;

import com.example.testes.linguagem.cliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByNameIgnoreCase(String name);

    List<Client> findByNameContainsIgnoreCase(String name);

    List<Client> findByIncomeGreaterThan(Double income);

    List<Client> findByIncomeLessThan(Double income);

    List<Client> findByIncomeBetween(Double incomeStart, Double incomeEnd);

    List<Client> findByBirthDateBetween(Instant birthDateStart, Instant birthDateEnd);
}
