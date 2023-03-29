package com.example.backend.linguagem.introducao;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Tag(name = "Introdução", description = "Introdução ao Spring Boot")
public class IntroducaoController {
    @GetMapping("/product")
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone", 3000, new Date()));
        products.add(new Product("Smart TV", 2000, new Date()));
        products.add(new Product("PlayStation 5", 3000, new Date()));
        return products;
    }

    @GetMapping("/client")
    public Client getClient() {
        return new Client(getProducts(), "João", 19);
    }
}
