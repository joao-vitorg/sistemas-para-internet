package br.com.iftm.lista.controller.segunda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BootstrapController {

    @GetMapping("bootstrap/{id}")
    public String bootstrap(@PathVariable int id) {
        return String.format("segunda/index%d", id);
    }

}
