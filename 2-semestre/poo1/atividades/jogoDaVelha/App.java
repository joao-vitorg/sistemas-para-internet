package jogoDaVelha;

import jogoDaVelha.entities.Tabuleiro;

import java.util.Scanner;

public class App {
    private static final Scanner s = new Scanner(System.in);
    private static final Tabuleiro tabuleiro = new Tabuleiro();

    public static void main(String[] args) {
        while (true) {
            if (tabuleiro.jogadaFinal()) break;
            userJoga();

            if (tabuleiro.jogadaFinal()) break;
            tabuleiro.pcJoga();
        }
    }

    private static void userJoga() {
        int x, y;

        System.out.println("---------- JOGADOR (X) ----------");

        do {
            System.out.print("Digite o X: ");
            x = s.nextInt();

            System.out.print("Digite o Y: ");
            y = s.nextInt();
        } while (!tabuleiro.userJoga(x, y));
    }
}
