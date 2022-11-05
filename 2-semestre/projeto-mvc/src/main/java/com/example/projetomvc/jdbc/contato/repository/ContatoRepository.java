package com.example.projetomvc.jdbc.contato.repository;

import com.example.projetomvc.jdbc.contato.model.Contato;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContatoRepository {
    final JdbcTemplate jdbc;
    final TipoRepository tipoRepository;

    public ContatoRepository(JdbcTemplate jdbc, TipoRepository tipoRepository) {
        this.jdbc = jdbc;
        this.tipoRepository = tipoRepository;
    }

    public Contato mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contato c = new Contato();
        c.setId(rs.getInt("id"));
        c.setNome(rs.getString("nome"));
        c.setTelefone(rs.getString("telefone"));
        c.setEndereco(rs.getString("endereco"));
        c.setTipo(tipoRepository.findById(rs.getInt("id_tipo")));
        return c;
    }

    public List<Contato> findAll() {
        return jdbc.query("select * from contato.pessoa", this::mapRow);
    }

    public Contato findById(int id) {
        return jdbc.queryForObject("select * from contato.pessoa where id = ?", this::mapRow, id);
    }

    public void save(Contato contato) {
        jdbc.update("insert into contato.pessoa(nome, telefone, endereco, id_tipo) values(?, ?, ?, ?)", contato.getNome(), contato.getTelefone(), contato.getEndereco(), contato.getTipo().getId());
    }

    public void update(Contato contato) {
        jdbc.update("update contato.pessoa set nome = ?, telefone = ?, endereco = ?, id_tipo = ? where id = ?", contato.getNome(), contato.getTelefone(), contato.getEndereco(), contato.getTipo().getId(), contato.getId());
    }

    public void delete(int id) {
        jdbc.update("delete from contato.pessoa where id = ?", id);
    }
}
