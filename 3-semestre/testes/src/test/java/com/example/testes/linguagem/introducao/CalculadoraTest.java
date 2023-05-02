package com.example.testes.linguagem.introducao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora(3);
    }

    @Test
    void semParametro() {
        calculadora = new Calculadora();
        assertEquals(0, calculadora.getMemoria());
    }

    @Test
    void comParametros() {
        assertEquals(3, calculadora.getMemoria());
    }

    @Test
    void somar() {
        calculadora.somar(-2);
        assertEquals(1, calculadora.getMemoria());
    }

    @Test
    void subtrair() {
        calculadora.subtrair(2);
        assertEquals(1, calculadora.getMemoria());
    }

    @Test
    void multiplicar() {
        calculadora.multiplicar(2);
        assertEquals(6, calculadora.getMemoria());
    }

    @Test
    void dividirZero() {
        assertThrows(Exception.class, () -> calculadora.dividir(0));
    }

    @Test
    void dividirPositivo() throws Exception {
        calculadora.dividir(2);
        assertEquals(1, calculadora.getMemoria());
    }

    @Test
    void exponenciarUm() throws Exception {
        calculadora.exponenciar(1);
        assertEquals(3, calculadora.getMemoria());
    }

    @Test
    void exponenciarDez() throws Exception {
        calculadora.exponenciar(10);
        assertEquals(59049, calculadora.getMemoria());
    }

    @Test
    void zerarMemoria() {
        calculadora.zerarMemoria();
        assertEquals(0, calculadora.getMemoria());
    }
}
