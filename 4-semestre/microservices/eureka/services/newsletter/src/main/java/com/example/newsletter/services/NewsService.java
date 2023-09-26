package com.example.newsletter.services;

import com.example.newsletter.models.news.News;
import com.example.newsletter.models.news.NewsDto;
import com.example.newsletter.repositories.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository repository;

    public NewsService(NewsRepository newsRepository) {
        this.repository = newsRepository;
    }

    public List<News> findAll() {
        return repository.findAll();
    }

    public News findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public News create(NewsDto newsDto) {
        return repository.save(new News(newsDto));
    }

    public News update(News news) {
        if (!repository.existsById(news.id())) {
            throw new RuntimeException("News not found");
        }

        return repository.save(news);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
