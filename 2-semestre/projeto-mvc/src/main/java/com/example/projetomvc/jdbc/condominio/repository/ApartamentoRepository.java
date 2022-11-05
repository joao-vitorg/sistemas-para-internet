package com.example.projetomvc.jdbc.condominio.repository;

import com.example.projetomvc.jdbc.condominio.model.Apartamento;
import com.example.projetomvc.jdbc.condominio.model.Proprietario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApartamentoRepository {
    final JdbcTemplate jdbc;
    final ProprietarioRepository proprietarioRepository;

    public ApartamentoRepository(JdbcTemplate jdbc, ProprietarioRepository proprietarioRepository) {
        this.jdbc = jdbc;
        this.proprietarioRepository = proprietarioRepository;
    }

    private RowMapper<Apartamento> apartamentoRowMapper() {
        return (rs, rowNum) -> {
            Apartamento a = new Apartamento();
            Proprietario p = proprietarioRepository.findById(rs.getInt("id_propietario"));
            a.setId(rs.getInt("id"));
            a.setNumero(rs.getInt("numero"));
            a.setQuartos(rs.getInt("quartos"));
            a.setTipo(rs.getString("tipo"));
            a.setProprietario(p);
            return a;
        };
    }

    public List<Apartamento> findAll() {
        return jdbc.query("select * from condominio.apartamento;", apartamentoRowMapper());
    }

    public Apartamento findById(int id) {
        return jdbc.queryForObject("select * from condominio.apartamento where id = ?;", apartamentoRowMapper(), id);
    }

    public void save(Apartamento apartamento) {
        jdbc.update("insert into condominio.apartamento (numero, quartos, tipo, id_propietario) values (?, ?, ?, ?);", apartamento.getNumero(), apartamento.getQuartos(), apartamento.getTipo(), apartamento.getProprietario().getId());
    }

    public void update(Apartamento apartamento) {
        jdbc.update("update condominio.apartamento set numero = ?, quartos = ?, tipo = ?, id_propietario = ? where id = ?;", apartamento.getNumero(), apartamento.getQuartos(), apartamento.getTipo(), apartamento.getProprietario().getId(), apartamento.getId());
    }

    public void deleteById(int id) {
        jdbc.update("delete from condominio.apartamento where id = ?;", id);
    }
}
