package com.example.primeira.controller;

import com.example.primeira.model.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RevisaoController {

    @GetMapping("revisao")
    public String home(Model model) {
        Pessoa pessoa = new Pessoa("João vitor");
        model.addAttribute("name", pessoa);
        model.addAttribute("outroname", "ifts");
        return "revisao";
    }

}
