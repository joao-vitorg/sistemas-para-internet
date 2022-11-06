package com.example.projetomvc.predio.repository;

import com.example.projetomvc.predio.model.Proprietario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProprietarioRepository {
    private final JdbcTemplate jdbc;

    public ProprietarioRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static Proprietario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Proprietario p = new Proprietario();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        p.setTelefone(rs.getString("telefone"));
        return p;
    }

    public List<Proprietario> findAll() {
        return jdbc.query("SELECT * FROM predio.proprietario", ProprietarioRepository::mapRow);
    }

    public Proprietario findById(int id) {
        return jdbc.queryForObject("SELECT * FROM predio.proprietario WHERE id = ?", ProprietarioRepository::mapRow, id);
    }

    public void save(Proprietario proprietario) {
        jdbc.update("INSERT INTO predio.proprietario (nome, telefone) VALUES (?, ?)", proprietario.getNome(), proprietario.getTelefone());
    }

    public void update(Proprietario proprietario) {
        jdbc.update("UPDATE predio.proprietario SET nome = ?, telefone = ? WHERE id = ?", proprietario.getNome(), proprietario.getTelefone(), proprietario.getId());
    }

    public void deleteById(int id) {
        jdbc.update("DELETE FROM predio.proprietario WHERE id = ?", id);
    }
}
