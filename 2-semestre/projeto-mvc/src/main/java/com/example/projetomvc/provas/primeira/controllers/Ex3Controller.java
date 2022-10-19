package com.example.projetomvc.provas.primeira.controllers;

import com.example.projetomvc.provas.primeira.models.Costumer;
import com.example.projetomvc.provas.primeira.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("provas/primeira/ex3")
public class Ex3Controller {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("product", new Product("PC", 1000, new Date()));
        model.addAttribute("customer", new Costumer("João", "Souza", "Homem", "Dinheiro", 1000));
        return "provas/primeira/ex3";
    }
}
