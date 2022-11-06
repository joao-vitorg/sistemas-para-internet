package com.example.projetomvc.predio.controller;

import com.example.projetomvc.predio.repository.ApartamentoRepository;
import com.example.projetomvc.predio.repository.ProprietarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/predio")
public class PredioController {
    final ApartamentoRepository apartamentoRepository;
    final ProprietarioRepository proprietarioRepository;

    public PredioController(ApartamentoRepository apartamentoRepository, ProprietarioRepository proprietarioRepository) {
        this.apartamentoRepository = apartamentoRepository;
        this.proprietarioRepository = proprietarioRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("apartamentos", apartamentoRepository.findAll());
        model.addAttribute("proprietarios", proprietarioRepository.findAll());
        return "predio/index";
    }
}
