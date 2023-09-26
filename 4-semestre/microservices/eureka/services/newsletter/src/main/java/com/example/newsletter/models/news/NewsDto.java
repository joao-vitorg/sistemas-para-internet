package com.example.newsletter.models.news;

import com.example.newsletter.models.post.Post;

import java.time.Instant;
import java.util.Set;

public record NewsDto(String title, Instant date, String editor, Set<Post> posts) {
}
