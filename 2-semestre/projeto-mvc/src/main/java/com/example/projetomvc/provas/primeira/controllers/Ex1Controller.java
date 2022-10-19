package com.example.projetomvc.provas.primeira.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("provas/primeira/ex1")
public class Ex1Controller {
    @GetMapping
    public String index() {
        return "provas/primeira/ex1";
    }
}
