package prova2_joaoSouza_q1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();

        Map<String, String> users = Map.of("joao", "123", "adm", "***");

        Transacao transacao = new Transacao();
        Cliente cliente = new Cliente("João Vitor", "123");
        Conta conta = new Conta(rand.nextInt(0, 1001), cliente, rand.nextFloat(0, 1001));
        float saldoAnterior = conta.getSaldo();
        gerarTransacoes(rand, transacao, conta);

        System.out.print("Exibir relatórios? ");
        if (s.nextLine().toLowerCase().charAt(0) != 's') return;

        System.out.print("Usuário: ");
        String usuario = s.nextLine();
        System.out.print("Senha: ");
        String senha = s.nextLine();
        try {
            login(users, usuario, senha);
            gerarRelatorio(transacao, conta, saldoAnterior);
        } catch (Restricoes e) {
            System.err.println(e.getMessage());
        }
    }

    private static void login(Map<String, String> users, String usuario, String senha) throws Restricoes {
        if (!(users.containsKey(usuario) && users.get(usuario).equals(senha)))
            throw new Restricoes("Usuário ou senha incorreta");
    }

    private static void gerarTransacoes(Random rand, Transacao transacao, Conta conta) {
        rand.ints(rand.nextInt(1, 11), 0, 1001).forEach(i -> {
            int operacao = rand.nextInt(Conta.SACAR, Conta.DEPOSITAR + 1);
            float valor = rand.nextFloat(0, 1001);
            transacao.realizarTransacao(new Date(), conta, "Transferência " + i, valor, operacao);
        });
    }

    private static void gerarRelatorio(Transacao transacao, Conta conta, float saldoAnterior) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        System.out.printf("Emitindo extrato da Conta Comum Número: %d\n", conta.getNumero());
        System.out.printf("Correntista: %s\n", conta.getCorrentista().getNome());
        System.out.printf("Saldo anterior: %.1f\n", saldoAnterior);
        transacao.getMovimentos().forEach(movimento -> {
            System.out.println("--------------------");
            System.out.printf("Data: %s\n", dateFormat.format(movimento.getData()));
            System.out.printf("Histórico: %s\n", movimento.getHistorico());
            System.out.printf("Valor: %.1f\n", movimento.getValor());
            System.out.printf("Operação: %s\n", movimento.getOperacao() == 0 ? "Saque" : "Depósito");
        });
        System.out.println("--------------------");
        System.out.printf("Saldo atual: %.1f\n", conta.getSaldo());
    }
}
