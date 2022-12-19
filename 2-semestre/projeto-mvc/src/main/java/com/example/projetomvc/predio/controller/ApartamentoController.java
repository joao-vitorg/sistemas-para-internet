package com.example.projetomvc.predio.controller;

import com.example.projetomvc.predio.model.Apartamento;
import com.example.projetomvc.predio.repository.ApartamentoRepository;
import com.example.projetomvc.predio.repository.ProprietarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/predio/apartamento")
public class ApartamentoController {
    final ApartamentoRepository apartamentoRepository;
    final ProprietarioRepository proprietarioRepository;

    public ApartamentoController(ApartamentoRepository apartamentoRepository, ProprietarioRepository proprietarioRepository) {
        this.apartamentoRepository = apartamentoRepository;
        this.proprietarioRepository = proprietarioRepository;
    }

    @GetMapping("cadastrar")
    public String cadastro(Model model) {
        model.addAttribute("apartamento", new Apartamento());
        model.addAttribute("proprietarios", proprietarioRepository.findAll());
        return "predio/apartamento/cadastrar";
    }

    @GetMapping("editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("apartamento", apartamentoRepository.findById(id));
        model.addAttribute("proprietarios", proprietarioRepository.findAll());
        return "predio/apartamento/editar";
    }

    @PostMapping("cadastrar")
    public String cadastro(@Valid Apartamento apartamento, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proprietarios", proprietarioRepository.findAll());
            return "predio/apartamento/cadastrar";
        }

        apartamentoRepository.save(apartamento);
        return "redirect:/predio";
    }

    @PostMapping("editar")
    public String editar(Apartamento apartamento) {
        apartamentoRepository.update(apartamento);
        return "redirect:/predio";
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam int id) {
        apartamentoRepository.deleteById(id);
        return "redirect:/predio";
    }
}
