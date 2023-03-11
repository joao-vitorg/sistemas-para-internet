package linguagem.revisao.ex7;

public class Calculo {
    private int saldo = 0;

    public Calculo(int saldo) {
        this.saldo = saldo;
    }

    public void credito(int valor) {
        saldo += valor;
    }

    public void debito(int valor) {
        saldo -= valor;
    }

    public int getSaldo() {
        return saldo;
    }
}
