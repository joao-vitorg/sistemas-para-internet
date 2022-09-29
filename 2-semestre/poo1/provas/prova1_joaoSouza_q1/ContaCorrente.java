package prova1_joaoSouza_q1;

public class ContaCorrente {
    private final String nome;
    private final String numeroConta;
    private final String tipoConta;
    private double saldo;
    private double limiteEspecial;

    public ContaCorrente(String nome, String numeroConta, String tipoConta, double saldo) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

    public ContaCorrente(String nome, String numeroConta, String tipoConta, double saldo, double limiteEspecial) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.limiteEspecial = limiteEspecial;
    }

    public void depositar(double valor) {
        saldo += valor * 0.999;
    }

    public boolean sacar(double valor) {
        valor *= 1.001;

        if (saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean sacar(double valor, double limite) {
        valor *= 1.002;

        if (saldo + limiteEspecial >= valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }
}
