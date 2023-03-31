package polimorfimo.ex11;

public class ContaEspecial extends Conta {
    private final double credito;

    public ContaEspecial(double saldo, double credito) {
        super(saldo);
        this.credito = credito;
    }

    @Override
    public void sacar(double valor) {
        if ((getSaldo() + credito) < valor) return;
        super.sacar(valor);
    }
}
