package com.example.logs.models;

import java.time.Instant;

public record LogDto(Action action, Instant date, String news) {
}
