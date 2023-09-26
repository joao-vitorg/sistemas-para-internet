package com.example.newsletter.models.news;

import com.example.newsletter.models.post.Post;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Set;

@Document
public record News(@Id String id, String title, Instant date, String editor, Set<Post> posts) {
    public News(NewsDto newsDto) {
        this(null, newsDto.title(), newsDto.date(), newsDto.editor(), newsDto.posts());
    }
}
