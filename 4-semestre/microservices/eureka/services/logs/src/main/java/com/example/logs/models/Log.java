package com.example.logs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public record Log(@Id String id, Action action, Instant date, String news) {
    public Log(LogDto logDto) {
        this(null, logDto.action(), logDto.date(), logDto.news());
    }
}
