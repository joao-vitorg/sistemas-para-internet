package com.example.newsletter.models.log;

import java.time.Instant;

public record LogDto(Action action, Instant date, String news) {
}
