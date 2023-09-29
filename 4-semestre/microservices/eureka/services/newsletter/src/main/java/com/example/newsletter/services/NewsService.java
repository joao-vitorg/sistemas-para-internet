package com.example.newsletter.services;

import com.example.newsletter.models.log.Action;
import com.example.newsletter.models.news.News;
import com.example.newsletter.models.news.NewsDto;
import com.example.newsletter.repositories.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository repository;
    private final NewsProducer producer;

    public NewsService(NewsRepository repository, NewsProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Transactional(readOnly = true)
    public List<News> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public News findById(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional()
    public String create(NewsDto newsDto) {
        News saved = repository.save(new News(newsDto));
        producer.sendLog(Action.CREATED, saved);
        return saved.id();
    }

    @Transactional
    public News update(News news) {
        if (!repository.existsById(news.id())) throw new RuntimeException("News not found");
        News saved = repository.save(news);
        producer.sendLog(Action.UPDATED, saved);
        return saved;
    }

    @Transactional
    public void delete(String id) {
        repository.deleteById(id);
        producer.sendLog(Action.DELETED, new News(id, null, null, null, null));
    }
}
