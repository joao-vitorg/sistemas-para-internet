package com.example.testes.linguagem.introducao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FuncionarioTest {
    Funcionario funcionario;

    @BeforeEach
    void setUp() {
        funcionario = new Funcionario("joao", 40, 55);
    }

    @Test
    void construtorPagamentoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Funcionario("joao", 1, 10));
    }

    @Test
    void construtorEntradaValorHoraInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Funcionario("joao", 40, 30));
    }

    @Test
    void construtorEntradaHorasInvalida() {
        assertThrows(IllegalArgumentException.class, () -> new Funcionario("joao", 50, 55));
    }

    @Test
    void construtorEntradasValida() {
        assertEquals(2200, funcionario.calcularPagamento());
    }

    @Test
    void modificarHorasPagamentoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setHorasTrabalhadas(1));
    }

    @Test
    void modificarHorasPagamentoValido() {
        funcionario.setHorasTrabalhadas(35);
        assertEquals(1925, funcionario.calcularPagamento());
    }

    @Test
    void modificarHorasEntradaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setHorasTrabalhadas(-5));
    }

    @Test
    void modificarHorasEntradaValida() {
        funcionario.setHorasTrabalhadas(35);
        assertEquals(35, funcionario.getHorasTrabalhadas());
    }

    @Test
    void modificarValorEntradaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> funcionario.setValorHoras(-5));
    }

    @Test
    void modificarValorEntradaValida() {
        funcionario.setValorHoras(60);
        assertEquals(60, funcionario.getValorHoras());
    }
}
