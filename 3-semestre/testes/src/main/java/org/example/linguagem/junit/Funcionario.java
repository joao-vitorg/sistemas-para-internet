package org.example.linguagem.junit;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHoras;

    public Funcionario(String nome, int horasTrabalhadas, double valorHoras) {
        this.nome = nome;
        this.valorHoras = valorHoras;
        this.horasTrabalhadas = horasTrabalhadas;

        validaValorHoras();
        validaHorasTrabalhadas();
        validaPagamento();
    }

    public double calcularPagamento() {
        return horasTrabalhadas * valorHoras;
    }

    private void validaPagamento() {
        if (calcularPagamento() < 1320) throw new IllegalArgumentException();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
        validaHorasTrabalhadas();
        validaPagamento();
    }

    private void validaHorasTrabalhadas() {
        if (horasTrabalhadas > 40 || horasTrabalhadas < 0) throw new IllegalArgumentException();
    }

    public double getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(double valorHoras) {
        this.valorHoras = valorHoras;
        validaValorHoras();
        validaPagamento();
    }

    private void validaValorHoras() {
        if (valorHoras >= 132 || valorHoras < 55) throw new IllegalArgumentException();
    }
}
