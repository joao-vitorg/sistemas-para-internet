package com.example.projetomvc.predio.controller;

import com.example.projetomvc.predio.model.Proprietario;
import com.example.projetomvc.predio.repository.ProprietarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/predio/proprietario")
public class ProprietarioController {
    final ProprietarioRepository proprietarioRepository;

    public ProprietarioController(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    @GetMapping("cadastrar")
    public String cadastro(Model model) {
        model.addAttribute("proprietario", new Proprietario());
        return "predio/proprietario/cadastrar";
    }

    @GetMapping("editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("proprietario", proprietarioRepository.findById(id));
        return "predio/proprietario/editar";
    }

    @PostMapping("cadastrar")
    public String cadastro(@Valid Proprietario proprietario, BindingResult result) {
        if (result.hasErrors()) return "predio/proprietario/cadastrar";
        proprietarioRepository.save(proprietario);
        return "redirect:/predio";
    }

    @PostMapping("editar")
    public String editar(Proprietario proprietario) {
        proprietarioRepository.update(proprietario);
        return "redirect:/predio";
    }

    @GetMapping("excluir")
    public String excluir(int id) {
        proprietarioRepository.deleteById(id);
        return "redirect:/predio";
    }
}
