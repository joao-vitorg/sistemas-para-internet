package heranca.exercicios.ex4;

public class Poupanca extends Conta {
    private int diaRendimento;

    public Poupanca() {
    }

    public Poupanca(double saldo, int diaRendimento) {
        super(saldo);
        this.diaRendimento = diaRendimento;
    }

    @Override
    public void setSaldo(double valor) {
        if (valor < 0) return;

        super.setSaldo(valor);
    }

    @Override
    public void sacar(double valor) {
        double novoValor = getSaldo() - valor;

        if (novoValor < 0) return;
        super.setSaldo(novoValor);
    }

    public int getDiaRendimento() {
        return diaRendimento;
    }

    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }
}
