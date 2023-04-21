package abstrato.exercicios.ex6;

public class Main {
    public static void main(String[] args) {
        Conta conta1 = new ContaCorrente();
        Conta conta2 = new ContaPoupanca();

        conta1.verificarConta();
        conta2.verificarConta();
    }
}
