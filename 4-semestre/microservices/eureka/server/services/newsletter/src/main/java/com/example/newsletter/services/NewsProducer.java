package com.example.newsletter.services;

import com.example.newsletter.models.log.Action;
import com.example.newsletter.models.log.LogDto;
import com.example.newsletter.models.news.News;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NewsProducer {
    private final RabbitTemplate template;

    public NewsProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendLog(Action action, News news) {
        LogDto log = new LogDto(action, new Date(), news.toString());
        template.convertAndSend("test", log);
    }
}
