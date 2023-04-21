package abstrato.exercicios.ex11;

import java.util.List;

public class Banco {
    public static void pagarJuros(List<Conta> contas) {
        contas.stream().filter(conta -> conta instanceof ContaPoupanca).forEach(conta -> conta.depositar(10));
    }
}
