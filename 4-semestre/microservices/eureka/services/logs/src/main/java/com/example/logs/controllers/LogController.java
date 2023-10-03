package com.example.logs.controllers;

import com.example.logs.models.Log;
import com.example.logs.services.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class LogController {
    private final LogService service;

    public LogController(LogService service) {
        this.service = service;
    }

    @GetMapping
    public List<Log> findAll() {
        return service.findAll();
    }
}
