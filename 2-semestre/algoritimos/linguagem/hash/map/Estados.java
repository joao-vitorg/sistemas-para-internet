package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> estados = new HashMap<>();

        System.out.print("Quantidade de estados: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println();

            System.out.print("Sigla do estado: ");
            String sigla = sc.nextLine();

            System.out.print("Nome do estado: ");
            String nome = sc.nextLine();

            estados.put(sigla, nome);
        }

        System.out.print("\nQuantidade de siglas para buscar: ");
        int p = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < p; i++) {
            String sigla = sc.nextLine();

            System.out.println(estados.getOrDefault(sigla, "Sigla não encontrada."));
        }
    }
}
