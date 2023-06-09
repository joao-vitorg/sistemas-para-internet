package com.example.testes.linguagem.cliente.repositories;

import com.example.testes.linguagem.cliente.entities.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ClientRepositoryTest {
    @Autowired
    private ClientRepository repository;

    @Test
    void nomeExistenteValido() {
        String name = "Jorge Amado";

        Optional<Client> result = repository.findByNameIgnoreCase(name);

        assertTrue(result.isPresent());
        assertEquals(name, result.get().getName());
    }

    @Test
    void nomeExistenteInvalido() {
        String name = "João";

        Optional<Client> result = repository.findByNameIgnoreCase(name);

        assertTrue(result.isEmpty());
    }

    @Test
    void nomeSimilarValido() {
        String name = "da";
        List<String> cpfs = List.of("10164334861", "10114274861");

        List<Client> result = repository.findByNameContainsIgnoreCase(name);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(client -> cpfs.contains(client.getCpf())));
    }

    @Test
    void nomeSimilarInvalido() {
        String name = "João";

        List<Client> result = repository.findByNameContainsIgnoreCase(name);

        assertTrue(result.isEmpty());
    }

    @Test
    void nomeSimilarVazio() {
        String name = "";

        List<Client> result = repository.findByNameContainsIgnoreCase(name);

        assertEquals(12, result.size());
    }

    @Test
    void salarioSuperior() {
        double income = 5000D;
        List<String> cpfs = List.of("10419244771", "10219344681");

        List<Client> result = repository.findByIncomeGreaterThan(income);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(client -> cpfs.contains(client.getCpf())));
    }

    @Test
    void salarioInferior() {
        double income = 2000D;
        List<String> cpfs = List.of("10114274861", "10619244881", "10619244881");

        List<Client> result = repository.findByIncomeLessThan(income);

        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(client -> cpfs.contains(client.getCpf())));
    }

    @Test
    void salarioIntervalo() {
        double incomeStart = 2000D;
        double incomeEnd = 3000D;
        List<String> cpfs = List.of("10619244881", "10419344882", "10204374161");

        List<Client> result = repository.findByIncomeBetween(incomeStart, incomeEnd);

        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(client -> cpfs.contains(client.getCpf())));
    }

    @Test
    void aniversarioIntervalo() {
        Instant dataI = Instant.parse("2017-12-25T20:30:50Z");
        Instant dataT = Instant.now();
        String cpf = "10619244881";

        List<Client> result = repository.findByBirthDateBetween(dataI, dataT);

        assertEquals(1, result.size());
        assertEquals(cpf, result.get(0).getCpf());
    }

    @Test
    void clienteAlterar() {
        Long id = 1L;
        String name = "João";
        String cpf = "11111111111";
        double income = 99_999D;

        Client client = repository.findById(id).orElseThrow();
        client.setName(name);
        client.setCpf(cpf);
        client.setIncome(income);
        repository.save(client);

        Client newClient = repository.findById(id).orElseThrow();

        assertEquals(name, newClient.getName());
        assertEquals(cpf, newClient.getCpf());
        assertEquals(income, newClient.getIncome());
    }
}
