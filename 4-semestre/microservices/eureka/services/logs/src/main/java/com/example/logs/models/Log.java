package com.example.logs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public record Log(@Id String id, String action, Instant date, Object object, String classType) {
}
