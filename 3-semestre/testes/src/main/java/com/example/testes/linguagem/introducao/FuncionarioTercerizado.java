package com.example.testes.linguagem.introducao;

public class FuncionarioTercerizado extends Funcionario {
    private double despesasAdicionais;

    public FuncionarioTercerizado(String nome, int horasTrabalhadas, double valorHoras, double despesasAdicionais) {
        super(nome, horasTrabalhadas, valorHoras);
        this.despesasAdicionais = despesasAdicionais;
        validaDespesasAdicionais();
    }

    @Override
    public double calcularPagamento() {
        return super.calcularPagamento() + despesasAdicionais * 1.1;
    }

    private void validaDespesasAdicionais() {
        if (despesasAdicionais > 1000 || despesasAdicionais < 0) throw new IllegalArgumentException();
    }

    public double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(double despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
        validaDespesasAdicionais();
    }
}
