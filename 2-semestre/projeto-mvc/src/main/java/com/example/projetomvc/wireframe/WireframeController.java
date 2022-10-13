package com.example.projetomvc.wireframe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wireframe")
public class WireframeController {
    @GetMapping("pag1")
    public String pag1() {
        return "wireframe/pag1";
    }

    @GetMapping("pag2")
    public String pag2() {
        return "wireframe/pag2";
    }
}
