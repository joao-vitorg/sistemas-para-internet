package com.example.introducao.controllers;

import com.example.introducao.models.Developer;
import com.example.introducao.services.DeveloperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/developer")
public class DeveloperController {
    private final DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Developer findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Developer> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        return service.create(developer);
    }

    @PutMapping
    public Developer update(@RequestBody Developer developer) {
        return service.update(developer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
