package com.example.backend.introducao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {
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
