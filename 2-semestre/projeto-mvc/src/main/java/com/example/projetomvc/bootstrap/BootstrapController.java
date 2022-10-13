package com.example.projetomvc.bootstrap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bootstrap")
public class BootstrapController {
    @GetMapping("1")
    public String etapa1() {
        return "bootstrap/etapa1";
    }

    @GetMapping("2")
    public String etapa2() {
        return "bootstrap/etapa2";
    }

    @GetMapping("3")
    public String etapa3() {
        return "bootstrap/etapa3";
    }
}
