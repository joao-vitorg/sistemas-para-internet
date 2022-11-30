package composicao.etapa2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppAvaInter2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, String> unidadeRemedio = new HashMap<>();
        unidadeRemedio.put("ml", "mililitro");
        unidadeRemedio.put("cp", "comprimido");
        unidadeRemedio.put("gr", "grama");
        unidadeRemedio.put("un", "unidade");

        ArrayList<Remedio> remedios = new ArrayList<>();

        System.out.print("Quantos remedios: ");
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("\nNome: ");
            String nome = s.nextLine();

            System.out.print("Laboratório: ");
            String lab = s.nextLine();

            String uni = "";
            do {
                try {
                    System.out.print("Unidade: ");
                    uni = s.nextLine();
                    if (!(uni.length() == 2)) throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    continue;
                }
            } while (!(unidadeRemedio.containsKey(uni)));

            remedios.add(new Remedio(nome, lab, uni));
        }

        System.out.println(remedios);
    }
}
