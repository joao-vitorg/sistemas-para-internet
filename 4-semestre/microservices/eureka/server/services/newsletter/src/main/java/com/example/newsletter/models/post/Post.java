package com.example.newsletter.models.post;

import java.util.Set;

public record Post(String title, String author, String body, Set<String> tags) {
}
