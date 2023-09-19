package com.example.introducao.services;

import com.example.introducao.models.Developer;
import com.example.introducao.repositories.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {
    private final DeveloperRepository repository;

    public DeveloperService(DeveloperRepository repository) {
        this.repository = repository;
    }

    public List<Developer> findAll() {
        return repository.findAll();
    }

    public Developer findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Developer create(Developer developer) {
        return repository.save(developer);
    }

    public Developer update(Developer developer) {
        if (!repository.existsById(developer.getId())) {
            throw new RuntimeException("Developer not found");
        }

        return repository.save(developer);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
