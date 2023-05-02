package abstrato.ex11;

public class ContaCorrente extends Conta {
    public ContaCorrente(double saldo) {
        super(saldo);
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() < valor) return;
        super.sacar(valor);
    }
}
