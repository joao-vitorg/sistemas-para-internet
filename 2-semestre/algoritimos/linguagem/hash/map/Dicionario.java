package map;

import java.util.HashMap;
import java.util.Scanner;

public class Dicionario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> dicionario = new HashMap<>();

        System.out.print("Quantidade de palavras: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("\nPalavra incorreta: ");
            String incorreto = sc.nextLine();

            System.out.print("\nPalavra correta: ");
            String correta = sc.nextLine();

            dicionario.put(incorreto, correta);
        }

        System.out.print("\nTexto a ser tratado: ");
        String[] palavras = sc.nextLine().split(" ");
        System.out.println();

        for (String palavra : palavras) {
            System.out.print(dicionario.getOrDefault(palavra, palavra) + " ");
        }
    }
}
