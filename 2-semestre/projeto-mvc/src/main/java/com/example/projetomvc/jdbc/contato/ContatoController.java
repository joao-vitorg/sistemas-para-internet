package com.example.projetomvc.jdbc.contato;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/jdbc/contato")
public class ContatoController {
    private final JdbcTemplate jdbc;

    public ContatoController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping()
    public String index(Model model) {
        List<Contato> listaContatos = jdbc.query("SELECT id, nome, telefone, endereco FROM contato", (rs, rowNum) -> {
            return new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("endereco"));
        });
        model.addAttribute("contatos", listaContatos);
        return "jdbc/contatos/index";
    }

    @GetMapping("cadastrar")
    public String cadastro(Model model) {
        model.addAttribute("contato", new Contato());
        return "jdbc/contatos/cadastrar";
    }

    @PostMapping("cadastrar")
    public String cadastro(Contato contato) {
        jdbc.update("insert into contato(nome, telefone, endereco) values (?,?,?)", contato.getNome(), contato.getTelefone(), contato.getEndereco());
        return "redirect:";
    }

    @GetMapping("editar")
    public String editar(@RequestParam(value = "id") Integer cod, Model model) {
        Contato contato = jdbc.queryForObject("select * from contato where id = ?;", (rs, rowNum) -> {
            return new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("endereco"));
        }, cod);
        model.addAttribute("contato", contato);
        return "jdbc/contatos/editar";
    }

    @PostMapping("editar")
    public String editar(Contato contato) {
        jdbc.update("update contato set nome = ?, telefone = ?, endereco = ?  where id = ?", contato.getNome(), contato.getTelefone(), contato.getEndereco(), contato.getId());
        return "redirect:";
    }

    @GetMapping("excluir")
    public String excluir(@RequestParam(value = "id") Integer cod) {
        jdbc.update("delete from contato where id = ?", cod);
        return "redirect:";
    }
}