package com.example.projetomvc.jdbc.professor.controller;

import com.example.projetomvc.jdbc.professor.model.Professor;
import com.example.projetomvc.jdbc.professor.repository.ProfessorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("jdbc/professor")
public class ProfessorController {
    final ProfessorRepository repository;

    public ProfessorController(ProfessorRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = {"", "/"})
    public String index(Model model) {
        model.addAttribute("professores", repository.findAll());
        return "jdbc/professor/index";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("Professor", new Professor());
        return "jdbc/professor/cadastrar";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Professor professor) {
        repository.save(professor);
        return "redirect:";
    }

    @GetMapping("editar")
    public String editar(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("Professor", repository.findById(id));
        return "jdbc/professor/editar";
    }

    @PostMapping("editar")
    public String editar(Professor professor) {
        repository.update(professor);
        return "redirect:";
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam(value = "id") int id) {
        repository.delete(id);
        return "redirect:";
    }
}
