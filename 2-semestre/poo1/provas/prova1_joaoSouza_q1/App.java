package prova1_joaoSouza_q1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ContaCorrente cc;
        double valor;
        int op;

        System.out.print("Nome: ");
        String nome = s.nextLine();

        System.out.print("Número da Conta: ");
        String numeroConta = s.nextLine();

        System.out.print("Tipo de Conta (comum/especial): ");
        String tipoConta = s.nextLine();

        System.out.print("Saldo: ");
        double saldo = s.nextDouble();

        if (tipoConta.equals("especial")) {
            System.out.print("Limite: ");
            double limiteEspecial = s.nextDouble();

            cc = new ContaCorrente(nome, numeroConta, tipoConta, saldo, limiteEspecial);
        } else {
            cc = new ContaCorrente(nome, numeroConta, tipoConta, saldo);
        }

        do {
            menu();
            op = s.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Valor: ");
                    valor = s.nextDouble();

                    if (tipoConta.equals("especial")) {
                        if (!cc.sacar(valor, valor)) System.out.println("Saldo insuficiente.");
                    } else {
                        if (!cc.sacar(valor)) System.out.println("Saldo insuficiente.");
                    }
                }
                case 2 -> {
                    System.out.print("Valor: ");
                    valor = s.nextDouble();

                    cc.depositar(valor);
                }
                case 3 -> exibir(cc);
            }
        } while (op != 4);
    }

    public static void menu() {
        System.out.print("""
                                
                ------- MENU ------
                1 - Saque
                2 - Deposito
                3 - Saldo
                4 - Sair
                                
                Opção:\040""");
    }

    public static void exibir(ContaCorrente cc) {
        System.out.printf("""
                                
                Nome: %s
                Número da Conta: %s
                Tipo de Conta: %s%s
                Saldo: R$%.2f
                """, cc.getNome(), cc.getNumeroConta(), cc.getTipoConta(), (cc.getTipoConta().equals("especial") ? String.format("\nLimite R$%.2f", cc.getLimiteEspecial()) : ""), cc.getSaldo());
    }
}
