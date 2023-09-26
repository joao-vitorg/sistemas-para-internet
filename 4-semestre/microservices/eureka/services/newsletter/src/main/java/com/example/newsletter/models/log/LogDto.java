package com.example.newsletter.models.log;

import com.example.newsletter.models.news.News;

import java.time.Instant;

public record LogDto(String action, Instant date, News news) {
}
