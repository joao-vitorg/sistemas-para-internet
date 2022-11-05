package com.example.projetomvc.jdbc.condominio.repository;

import com.example.projetomvc.jdbc.condominio.model.Proprietario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProprietarioRepository {
    private final JdbcTemplate jdbc;

    public ProprietarioRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static RowMapper<Proprietario> proprietarioRowMapper() {
        return (rs, rowNum) -> {
            Proprietario p = new Proprietario();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setTelefone(rs.getString("telefone"));
            return p;
        };
    }

    public List<Proprietario> findAll() {
        return jdbc.query("SELECT * FROM condominio.propietario", proprietarioRowMapper());
    }

    public Proprietario findById(int id) {
        return jdbc.queryForObject("SELECT * FROM condominio.propietario WHERE id = ?", proprietarioRowMapper(), id);
    }

    public void save(Proprietario proprietario) {
        jdbc.update("INSERT INTO condominio.propietario (nome, telefone) VALUES (?, ?)", proprietario.getNome(), proprietario.getTelefone());
    }

    public void update(Proprietario proprietario) {
        jdbc.update("UPDATE condominio.propietario SET nome = ?, telefone = ? WHERE id = ?", proprietario.getNome(), proprietario.getTelefone(), proprietario.getId());
    }

    public void deleteById(int id) {
        jdbc.update("DELETE FROM condominio.propietario WHERE id = ?", id);
    }
}
