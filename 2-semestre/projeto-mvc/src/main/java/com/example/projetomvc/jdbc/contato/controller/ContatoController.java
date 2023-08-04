package com.example.projetomvc.jdbc.contato.controller;

import com.example.projetomvc.jdbc.contato.model.Contato;
import com.example.projetomvc.jdbc.contato.repository.ContatoRepository;
import com.example.projetomvc.jdbc.contato.repository.TipoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jdbc/contato")
public class ContatoController {
    final ContatoRepository contatoRepository;
    final TipoRepository tipoRepository;

    public ContatoController(ContatoRepository contatoRepository, TipoRepository tipoRepository) {
        this.contatoRepository = contatoRepository;
        this.tipoRepository = tipoRepository;
    }

    @GetMapping(value = {"", "/"})
    public String index(Model model) {
        model.addAttribute("contatos", contatoRepository.findAll());
        model.addAttribute("tipos", tipoRepository.findAll());
        return "jdbc/contato/index";
    }

    @GetMapping("/cadastrar")
    public String cadastro(Model model) {
        model.addAttribute("contato", new Contato());
        model.addAttribute("tipos", tipoRepository.findAll());
        return "jdbc/contato/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastro(Contato contato) {
        contatoRepository.save(contato);
        return "redirect:";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam(value = "id") Integer id, Model model) {
        model.addAttribute("contato", contatoRepository.findById(id));
        model.addAttribute("tipos", tipoRepository.findAll());
        return "jdbc/contato/editar";
    }

    @PostMapping("/editar")
    public String editar(Contato contato) {
        contatoRepository.update(contato);
        return "redirect:";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam(value = "id") Integer id) {
        contatoRepository.delete(id);
        return "redirect:";
    }
}
