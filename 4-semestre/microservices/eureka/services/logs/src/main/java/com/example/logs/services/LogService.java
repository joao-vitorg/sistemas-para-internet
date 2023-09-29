package com.example.logs.services;

import com.example.logs.models.Log;
import com.example.logs.repositories.LogRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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

    @RabbitListener(queues = "test")
    public void create(String logDto) {
        System.out.println(logDto);
//        return logRepository.save(new Log(logDto));
    }
}
