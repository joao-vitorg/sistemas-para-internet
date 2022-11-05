package com.example.projetomvc.jdbc.condominio.controller;

import com.example.projetomvc.jdbc.condominio.model.Apartamento;
import com.example.projetomvc.jdbc.condominio.repository.ApartamentoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jdbc/condominio/apartamento")
public class CondominioController {
    final JdbcTemplate jdbc;
    final ApartamentoRepository apartamentoRepository;

    public CondominioController(JdbcTemplate jdbc, ApartamentoRepository apartamentoRepository) {
        this.jdbc = jdbc;
        this.apartamentoRepository = apartamentoRepository;
    }

    @GetMapping
    public String apartamento(Model model) {
        model.addAttribute("apartamentos", apartamentoRepository.findAll());
        return "jdbc/condominio/apartamento/index";
    }

    @GetMapping("cadastro")
    public String cadastro(Model model) {
        model.addAttribute("apartamento", new Apartamento());
        return "jdbc/condominio/apartamento/cadastrar";
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam int id) {
        apartamentoRepository.deleteById(id);
        return "redirect:";
    }
}
