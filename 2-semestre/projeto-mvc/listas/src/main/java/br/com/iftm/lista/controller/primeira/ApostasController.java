package br.com.iftm.lista.controller.primeira;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ApostasController {

    @GetMapping("apostas")
    public String home(Model model) {
        Random random = new Random();
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            numeros.add(random.nextInt(60) + 1);
        }

        model.addAttribute("numeros", numeros);

        return "primeira/apostas";
    }

}
