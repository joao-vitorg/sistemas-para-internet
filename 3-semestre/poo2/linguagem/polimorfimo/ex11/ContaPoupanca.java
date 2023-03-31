package polimorfimo.ex11;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() < valor) return;
        super.sacar(valor);
    }
}
