package solid.introducao.banco;

import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class ContaBancaria {
    private final Set<Transacao> historico = new HashSet<>();
    private int numeroConta;
    private double saldo;

    public ContaBancaria(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void sacar(double valor) {
        if (saldo < valor || valor < 0) throw new InputMismatchException();
        saldo -= valor;
        historico.add(new Transacao(-valor, saldo));
    }

    public void depositar(double valor) {
        if (valor < 0) throw new InputMismatchException();
        saldo += valor;
        historico.add(new Transacao(valor, saldo));
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Set<Transacao> getHistorico() {
        return Collections.unmodifiableSet(historico);
    }

    @Override
    public String toString() {
        return String.valueOf(saldo);
    }
}
