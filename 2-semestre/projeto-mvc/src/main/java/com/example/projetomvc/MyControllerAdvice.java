package com.example.projetomvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
    public String violacaoDeIntegridade(java.sql.SQLIntegrityConstraintViolationException ex, final RedirectAttributes redirectAttributes) {
        String errorMessage = ex.getMessage();
        if (errorMessage.contains("Cannot delete or update a parent row")) {
            redirectAttributes.addFlashAttribute("mensagem", "O proprietário tem apartamento cadastrado. Não é possível excluí-lo do sistema");
            return "redirect:/predio";
        }

        return "error";
    }
}
