package polimorfimo.ex11;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();

        contas.add(new ContaCorrente(10));
        contas.add(new ContaPoupanca(20));
        contas.add(new ContaEspecial(30, 10));

        Banco.pagarJuros(contas);

        contas.forEach(System.out::println);
    }
}
