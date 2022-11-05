package com.example.projetomvc.jdbc.contato.controller;

import com.example.projetomvc.jdbc.contato.model.Tipo;
import com.example.projetomvc.jdbc.contato.repository.TipoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jdbc/contato/tipo")
public class TipoController {
    final TipoRepository tipoRepository;

    public TipoController(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @GetMapping("cadastrar")
    public String cadastro(Model model) {
        model.addAttribute("tipo", new Tipo());
        return "jdbc/contato/tipo/cadastrar";
    }

    @GetMapping("editar")
    public String editar(@RequestParam(value = "id") Integer id, Model model) {
        model.addAttribute("tipo", tipoRepository.findById(id));
        return "jdbc/contato/tipo/editar";
    }

    @PostMapping("cadastrar")
    public String cadastro(Tipo tipo) {
        tipoRepository.save(tipo);
        return "redirect:/jdbc/contato";
    }

    @PostMapping("editar")
    public String editar(Tipo tipo) {
        tipoRepository.update(tipo);
        return "redirect:/jdbc/contato";
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam(value = "id") Integer id) {
        tipoRepository.delete(id);
        return "redirect:/jdbc/contato";
    }
}
