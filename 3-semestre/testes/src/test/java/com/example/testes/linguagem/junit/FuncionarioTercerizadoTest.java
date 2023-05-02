package com.example.testes.linguagem.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FuncionarioTercerizadoTest {
    FuncionarioTercerizado funcionarioTercerizado;

    @BeforeEach
    void setUp() {
        funcionarioTercerizado = new FuncionarioTercerizado("as", 40, 55, 30);
    }

    @Test
    void construtorEntradasInvalidas() {
        assertThrows(IllegalArgumentException.class, () -> new FuncionarioTercerizado("joao", 40, 55, -1));
    }

    @Test
    void construtorEntradasValidas() {
        assertEquals(2233, funcionarioTercerizado.calcularPagamento());
    }

    @Test
    void modificarDespesasInvalido() {
        assertThrows(IllegalArgumentException.class, () -> funcionarioTercerizado.setDespesasAdicionais(2000));
    }

    @Test
    void modificarDespesasValido() {
        funcionarioTercerizado.setDespesasAdicionais(500);
        assertEquals(2750, funcionarioTercerizado.calcularPagamento());
    }
}
