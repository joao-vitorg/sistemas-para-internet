package com.example.projetomvc.provas.primeira.controllers;

import com.example.projetomvc.provas.primeira.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("provas/primeira/ex2")
public class Ex2Controller {
    @GetMapping
    public String index(Model model) {
        List<Product> listadeprodutos = new ArrayList<>();
        listadeprodutos.add(new Product("PC", 1000, new Date()));
        model.addAttribute("listadeprodutos", listadeprodutos);
        return "provas/primeira/ex2";
    }
}
