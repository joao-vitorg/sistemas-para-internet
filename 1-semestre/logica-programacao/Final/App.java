import entities.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

import static entities.Cliente.precos;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Informe a quantidade de clientes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Dados do %do. cliente:\n", i + 1);
            System.out.print("Nome: ");
            String nome = sc.next();

            System.out.print("Telefone: ");
            String telefone = sc.next();

            System.out.print("Tipo: ");
            int tipo = sc.nextInt();

            System.out.print("Minutos: ");
            int minutos = sc.nextInt();

            System.out.println();
            clientes.add(new Cliente(nome, telefone, tipo, minutos));
        }

        System.out.println("Informe o preco basico e excedente de cada tipo de conta:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("Tipo %d: ", i);

            precos[i][0] = sc.nextDouble();
            precos[i][1] = sc.nextDouble();
        }

        Menu();
    }

    private static void Menu() {
        while (true) {
            System.out.println("\nMENU DE OPCOES:");
            System.out.println("1) Relatorio de clientes");
            System.out.println("2) A receita total");
            System.out.println("3) Conta foi mais barata");
            System.out.println("4) Consumo medio de clientes tipo 1.");
            System.out.println("5) Clientes que consumiram acima de 120 pulsos.");
            System.out.println("6) A porcentagem de clientes tipo 2");
            System.out.println("7) Sair");
            System.out.print("Informe uma opcao: ");
            int op = sc.nextInt();

            System.out.println();
            if (op == 1) RelatorioClientes();
            else if (op == 2) ReceitaTotal();
            else if (op == 3) ContaMaisBarata();
            else if (op == 4) ConsumoMedioTipo1();
            else if (op == 5) ClientesAcima120Minutos();
            else if (op == 6) PorcentagemClientes2();
            else if (op == 7) break;
        }
    }

    private static void RelatorioClientes() {
        clientes.forEach(System.out::println);
    }

    private static void ReceitaTotal() {
        System.out.printf("A receita total: %.2f\n", clientes.stream()
                .mapToDouble(Cliente::ValorDaConta)
                .sum());
    }

    private static void ContaMaisBarata() {
        System.out.println("Conta foi mais barata:");
        clientes.stream()
                .reduce((c, c2) -> c.ValorDaConta() < c2.ValorDaConta() ? c : c2)
                .ifPresent(System.out::println);
    }

    private static void ConsumoMedioTipo1() {
        OptionalDouble average = clientes.stream()
                .filter(cliente -> cliente.tipo() == 1)
                .mapToDouble(Cliente::minutos).average();
        System.out.printf("Consumo medio de clientes tipo 1: %.2f\n", (average.isPresent() ? average.getAsDouble() : 0));
    }

    private static void ClientesAcima120Minutos() {
        System.out.println("Clientes que consumiram acima de 120 pulsos:");
        clientes.stream()
                .filter(cliente -> cliente.minutos() > 120)
                .forEach(System.out::println);
    }

    private static void PorcentagemClientes2() {
        long porcentagem = clientes.stream().filter(cliente -> cliente.tipo() == 2).count();
        System.out.printf("Porcentagem de clientes tipo 2: %.2f%%\n", (100.0 * porcentagem) / clientes.size());
    }
}
