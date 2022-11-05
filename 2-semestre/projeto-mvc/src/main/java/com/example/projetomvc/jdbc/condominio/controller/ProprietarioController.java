package com.example.projetomvc.jdbc.condominio.controller;

import com.example.projetomvc.jdbc.condominio.model.Proprietario;
import com.example.projetomvc.jdbc.condominio.repository.ProprietarioRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jdbc/condominio/proprietario")
public class ProprietarioController {
    final JdbcTemplate jdbc;
    final ProprietarioRepository proprietarioRepository;

    public ProprietarioController(JdbcTemplate jdbc, ProprietarioRepository proprietarioRepository) {
        this.jdbc = jdbc;
        this.proprietarioRepository = proprietarioRepository;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("proprietarios", proprietarioRepository.findAll());
        return "jdbc/condominio/proprietario/index";
    }

    @GetMapping("cadastrar")
    public String cadastro(Model model) {
        model.addAttribute("proprietario", new Proprietario());
        return "jdbc/condominio/proprietario/cadastrar";
    }

    @PostMapping("cadastrar")
    public String cadastro(Proprietario proprietario) {
        proprietarioRepository.save(proprietario);
        return "redirect:";
    }

    @GetMapping("editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("proprietario", proprietarioRepository.findById(id));
        return "jdbc/condominio/proprietario/editar";
    }

    @PostMapping("editar")
    public String editar(Proprietario proprietario) {
        proprietarioRepository.update(proprietario);
        return "redirect:";
    }

    @GetMapping("excluir")
    public String excluir(int id) {
        proprietarioRepository.deleteById(id);
        return "redirect:";
    }
}
