package polimorfimo.ex6;

public class ContaCorrente extends Conta {
    @Override
    public void verificarConta() {
        System.out.println("Conta Corrente");
    }
}
