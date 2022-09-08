package br.com.iftm.lista.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Controller
public class ApostasController {

    @GetMapping("apostas")
    public String home(Model model) {
        Random random = new Random();

        List<Integer> numeros = new ArrayList<>(IntStream.rangeClosed(1, 60).boxed().toList());

        model.addAttribute("n1", numeros.remove(random.nextInt(0, 59)));
        model.addAttribute("n2", numeros.remove(random.nextInt(0, 58)));
        model.addAttribute("n3", numeros.remove(random.nextInt(0, 57)));
        model.addAttribute("n4", numeros.remove(random.nextInt(0, 56)));
        model.addAttribute("n5", numeros.remove(random.nextInt(0, 55)));
        model.addAttribute("n6", numeros.remove(random.nextInt(0, 54)));

        return "apostas";
    }

}
