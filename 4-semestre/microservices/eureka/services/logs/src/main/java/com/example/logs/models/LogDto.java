package com.example.logs.models;

import java.io.Serializable;
import java.util.Date;

public record LogDto(Action action, Date date, String news) implements Serializable {
}
