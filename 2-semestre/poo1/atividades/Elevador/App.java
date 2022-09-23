package Elevador;

import Elevador.entities.Elevador;

import java.util.Scanner;

public class App {
    private static Elevador elevador;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Total andares: ");
        int totalAndates = s.nextInt();

        System.out.print("Capacidade elevador: ");
        int capacidadeElevador = s.nextInt();

        elevador = new Elevador(totalAndates, capacidadeElevador);

        do {
            System.out.print("""

                    1 - Entrar Pessoa
                    2 - Sair Pessoa
                    3 - Subir Andar
                    4 - Descer Andar
                    5 - Exibir
                    6 - Parar

                    Digite a opção:\040""");
        } while (simular(s.nextInt()));
    }

    private static boolean simular(int op) {
        System.out.println();

        switch (op) {
            case 5 -> {
                System.out.println(elevador.exibir());
                return true;
            }
            case 6 -> {
                System.out.println("FIM!!!!");
                return false;
            }
        }

        boolean result = switch (op) {
            case 1 -> elevador.entrar();
            case 2 -> elevador.sair();
            case 3 -> elevador.subir();
            case 4 -> elevador.descer();
            default -> false;
        };

        System.out.println(result ? "OK!" : "ERRO!!!");
        return true;
    }
}
