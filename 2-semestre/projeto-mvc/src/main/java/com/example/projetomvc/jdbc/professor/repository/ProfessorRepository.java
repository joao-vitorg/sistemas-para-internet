package com.example.projetomvc.jdbc.professor.repository;

import com.example.projetomvc.jdbc.professor.model.Professor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProfessorRepository {
    final JdbcTemplate jdbc;

    public ProfessorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Professor p = new Professor();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));
        return p;
    }

    public List<Professor> findAll() {
        return jdbc.query("select * from professor.professor", ProfessorRepository::mapRow);
    }

    public Professor findById(int id) {
        return jdbc.queryForObject("select * from professor.professor where id = ?;", ProfessorRepository::mapRow, id);
    }

    public void save(Professor professor) {
        jdbc.update("insert into professor.professor(nome) values (?)", professor.getNome());
    }

    public void update(Professor professor) {
        jdbc.update("update professor.professor set nome = ? where id = ?", professor.getNome(), professor.getId());
    }

    public void delete(int id) {
        jdbc.update("delete from professor.professor where id = ?", id);
    }
}
