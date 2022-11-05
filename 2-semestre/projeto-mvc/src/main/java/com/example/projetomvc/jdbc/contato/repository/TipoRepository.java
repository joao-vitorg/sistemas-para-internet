package com.example.projetomvc.jdbc.contato.repository;

import com.example.projetomvc.jdbc.contato.model.Tipo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TipoRepository {
    final JdbcTemplate jdbc;

    public TipoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public static Tipo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tipo t = new Tipo();
        t.setId(rs.getInt("id"));
        t.setDescricao(rs.getString("descricao"));
        return t;
    }

    public List<Tipo> findAll() {
        return jdbc.query("select * from contato.tipo", TipoRepository::mapRow);
    }

    public Tipo findById(int id) {
        return jdbc.queryForObject("select * from contato.tipo where id = ?", TipoRepository::mapRow, id);
    }

    public void save(Tipo tipo) {
        jdbc.update("insert into contato.tipo(descricao) values(?)", tipo.getDescricao());
    }

    public void update(Tipo tipo) {
        jdbc.update("update contato.tipo set descricao = ? where id = ?", tipo.getDescricao(), tipo.getId());
    }

    public void delete(int id) {
        jdbc.update("delete from contato.tipo where id = ?", id);
    }
}
