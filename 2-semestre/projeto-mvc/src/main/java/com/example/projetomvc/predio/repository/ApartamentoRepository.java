package com.example.projetomvc.predio.repository;

import com.example.projetomvc.predio.model.Apartamento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ApartamentoRepository {
    final JdbcTemplate jdbc;
    final ProprietarioRepository proprietarioRepository;

    public ApartamentoRepository(JdbcTemplate jdbc, ProprietarioRepository proprietarioRepository) {
        this.jdbc = jdbc;
        this.proprietarioRepository = proprietarioRepository;
    }

    private Apartamento mapRow(ResultSet rs, int rowNum) throws SQLException {
        Apartamento a = new Apartamento();
        a.setId(rs.getInt("id"));
        a.setNumero(rs.getInt("numero"));
        a.setQuartos(rs.getInt("qtd_quartos"));
        a.setTipo(rs.getString("tipo_ocupacao"));
        a.setProprietario(proprietarioRepository.findById(rs.getInt("id_proprietario")));
        return a;
    }

    public List<Apartamento> findAll() {
        return jdbc.query("select * from predio.apartamento;", this::mapRow);
    }

    public Apartamento findById(int id) {
        return jdbc.queryForObject("select * from predio.apartamento where id = ?;", this::mapRow, id);
    }

    public void save(Apartamento apartamento) {
        jdbc.update("insert into predio.apartamento (numero, qtd_quartos, tipo_ocupacao, id_proprietario) values (?, ?, ?, ?);", apartamento.getNumero(), apartamento.getQuartos(), apartamento.getTipo(), apartamento.getProprietario().getId());
    }

    public void update(Apartamento apartamento) {
        jdbc.update("update predio.apartamento set numero = ?, qtd_quartos = ?, tipo_ocupacao = ?, id_proprietario = ? where id = ?;", apartamento.getNumero(), apartamento.getQuartos(), apartamento.getTipo(), apartamento.getProprietario().getId(), apartamento.getId());
    }

    public void deleteById(int id) {
        jdbc.update("delete from predio.apartamento where id = ?;", id);
    }
}
