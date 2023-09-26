package com.example.newsletter.models.post;

import com.example.newsletter.models.tag.Tag;

import java.util.Set;

public record Post(String title, String author, String body, Set<Tag> tags) {
}
