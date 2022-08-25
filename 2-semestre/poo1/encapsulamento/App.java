import entities.JogadorDeFutebol;

import java.util.Scanner;

public class App {
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        JogadorDeFutebol jogador;

        String nome = leString("nome");
        String nascimento = leString("nascimento");
        String altura = leString("altura");
        String peso = leString("peso");
        String nacionalidade = leString("nacionalidade");
        String posicao = leString("posicao");

        jogador = new JogadorDeFutebol(nome, nascimento, altura, peso, nacionalidade, posicao);

        System.out.println();
        System.out.println(jogador);
        System.out.println(jogador.calculaAposentadoria());
    }

    private static String leString(String op) {
        System.out.printf("Digite o %s: ", op);
        return s.nextLine();
    }
}