package com.example.newsletter.models.log;

import java.util.Date;

public record LogDto(Action action, Date date, String news) {
}
