package com.example.newsletter.services;

import com.example.newsletter.models.log.Action;
import com.example.newsletter.models.log.LogDto;
import com.example.newsletter.models.news.News;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class NewsProducer {
    private final RabbitTemplate template;
    private final ObjectMapper mapper;

    public NewsProducer(RabbitTemplate template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public void sendLog(Action action, News news) {
        try {
            LogDto log = new LogDto(action, Instant.now(), mapper.writeValueAsString(news));
            template.convertAndSend("test", mapper.writeValueAsString(log));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
