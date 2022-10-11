package tiposGeometricos;

import tiposGeometricos.entities.Cidade;
import tiposGeometricos.entities.Pessoa;
import tiposGeometricos.entities.Vetor;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String nomeP, nomeC, adjetivo, estado, naturalidade;
        char sexo;

        System.out.print("Quantidade de pessoas: ");
        int tamP = s.nextInt();

        System.out.print("Quantidade de cidades: ");
        int tamC = s.nextInt();

        s.nextLine();

        Vetor<Pessoa> vp = new Vetor<>(tamP);
        Vetor<Cidade> vc = new Vetor<>(tamC);

        System.out.println("\n========== Pessoas ==========");
        for (int i = 0; i < tamP; i++) {
            System.out.printf("\n---------- Pessoa %d ----------\n", i + 1);

            System.out.print("Nome: ");
            nomeP = s.nextLine();

            System.out.print("Sexo (F/M): ");
            sexo = s.nextLine().toLowerCase().charAt(0);

            System.out.print("Naturalidade: ");
            naturalidade = s.nextLine();

            vp.setVet(i, new Pessoa(nomeP, sexo, naturalidade));
        }

        System.out.println("\n========== Cidades ==========");
        for (int i = 0; i < tamC; i++) {
            System.out.printf("\n---------- Cidade %d ----------\n", i + 1);

            System.out.print("Nome: ");
            nomeC = s.nextLine();

            System.out.print("Adjetivo: ");
            adjetivo = s.nextLine();

            System.out.print("Estado: ");
            estado = s.nextLine();

            vc.setVet(i, new Cidade(nomeC, adjetivo, estado));
        }

        System.out.println("\n========== Consulta ==========");

        while (true) {
            Pessoa p = null;
            Cidade c = null;

            System.out.print("\nDigite o nome da pessoa (-1 para sair): ");
            String op = s.nextLine();

            if (op.equals("-1")) break;

            System.out.println();

            for (int i = 0; i < tamP; i++) {
                if (vp.getVet(i).getNome().equals(op)) {
                    p = vp.getVet(i);
                    break;
                }
            }

            if (p == null) {
                System.out.printf("%s nasceu em cidade desconhecida.\n", op);
                continue;
            }

            for (int i = 0; i < tamC; i++) {
                if (p.getNaturalidade().equals(vc.getVet(i).getNome())) {
                    c = vc.getVet(i);
                    String adj = c.getAdjetivo();

                    if (adj.contains("/")) {
                        adj = adj.split("/")[(p.getSexo() == 'f') ? 1 : 0];
                    }

                    System.out.printf("%c %s %s nasceu em %s - %s.\n", (p.getSexo() == 'f' ? 'A' : 'O'), adj, p.getNome(), c.getNome(), c.getEstado());
                }
            }

            if (c == null) {
                System.out.printf("%c %s nasceu em %s.\n", (p.getSexo() == 'f' ? 'A' : 'O'), p.getNome(), p.getNaturalidade());
            }
        }
    }
}
