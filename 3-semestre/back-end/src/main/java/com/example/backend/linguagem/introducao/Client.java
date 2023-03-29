package com.example.backend.linguagem.introducao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Client {
    private final List<Product> products;
    private String name;
    private int age;
}
