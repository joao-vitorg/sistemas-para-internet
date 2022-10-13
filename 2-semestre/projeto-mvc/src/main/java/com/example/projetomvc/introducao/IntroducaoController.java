package com.example.projetomvc.introducao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/introducao")
public class IntroducaoController {
    Random random = new Random();

    @GetMapping("revisao")
    public String revisao(Model model) {
        Pessoa pessoa = new Pessoa("João vitor");
        model.addAttribute("name", pessoa);
        model.addAttribute("outroname", "ifts");

        return "introducao/revisao";
    }

    @GetMapping("apostas")
    public String apostas(Model model) {
        List<Integer> numeros = IntStream.range(0, 6).mapToObj(i -> random.nextInt(60) + 1).toList();
        model.addAttribute("numeros", numeros);

        return "introducao/apostas";
    }
}
