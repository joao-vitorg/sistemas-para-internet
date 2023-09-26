package com.example.logs.services;

import com.example.logs.models.Log;
import com.example.logs.repositories.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public Log create(Log log) {
        return logRepository.save(log);
    }
}
