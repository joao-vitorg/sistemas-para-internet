package composicao.etapa3;

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

        System.out.print("\nNome do animal: ");
        String nomeAnimal = s.nextLine();
        System.out.print("Observações: ");
        String observacoes = s.nextLine();
        System.out.print("Queixa: ");
        String queixa = s.nextLine();
        System.out.print("Hisorico: ");
        String hisorico = s.nextLine();

        Consulta consulta = new Consulta(nomeAnimal, observacoes, queixa, hisorico);

        System.out.println();
        for (int i = 0; i < remedios.size(); i++) {
            System.out.printf("(%d) : %s\n", i + 1, remedios.get(i));
        }

        while (true) {
            System.out.print("\nIndex do remedio (-1 para sair): ");
            int index = s.nextInt();
            if (index == -1) break;

            System.out.print("Dose: ");
            double dose = s.nextDouble();
            System.out.print("Duração: ");
            int duracao = s.nextInt();

            consulta.addItem(dose, duracao, remedios.get(index - 1));
        }

        System.out.println();
        for (ItemReceita item : consulta.getItems()) {
            System.out.printf("%s - %.2f %s - %d dias\n", item.getRemedio(), item.getDose(), unidadeRemedio.get(item.getRemedio().getUnidade()), item.getDuracao());
        }


        System.out.println("\n" + consulta);
    }
}
