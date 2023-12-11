package com.example.logs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public record Log(@Id String id, Action action, Date date, String news) {
    public Log(LogDto logDto) {
        this(null, logDto.action(), logDto.date(), logDto.news());
    }
}
