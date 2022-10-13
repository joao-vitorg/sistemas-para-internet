package com.example.projetomvc.jdbc.professor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("jdbc/professor")
public class ProfessorController {
    final JdbcTemplate jdbc;

    public ProfessorController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping()
    public String index(Model model) {
        List<Professor> professores = jdbc.query("select id, nome from professor", (rs, rowNum) -> {
            return new Professor(rs.getLong("id"), rs.getString("nome"));
        });
        model.addAttribute("professores", professores);
        return "jdbc/professor/index";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("Professor", new Professor());
        return "jdbc/professor/cadastrar";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Professor professor) {
        jdbc.update("insert into professor(nome) values (?)", professor.getNome());
        return "redirect:";
    }

    @GetMapping("editar")
    public String editar(@RequestParam(value = "id") int id, Model model) {
        Professor professor = jdbc.queryForObject("select id, nome from professor where id = ?;", (rs, rowNum) -> new Professor(rs.getLong("id"), rs.getString("nome")), id);
        model.addAttribute("Professor", professor);
        return "jdbc/professor/editar";
    }

    @PostMapping("editar")
    public String editar(Professor professor) {
        jdbc.update("update professor set nome = ? where id = ?", professor.getNome(), professor.getId());
        return "redirect:";
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam(value = "id") int id) {
        jdbc.update("delete from professor where id = ?", id);
        return "redirect:";
    }
}
