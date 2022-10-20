import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DadosAlunos {
    static List<Aluno> alunos = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            System.out.printf("Nome aluno %d: ", i);
            Aluno aluno = new Aluno(s.nextLine());

            leDados(aluno.emails, "E-mail", i);
            leDados(aluno.telefones, "Telefone", i);

            alunos.add(aluno);

            System.out.print("Deseja cadastrar outro aluno? ");
            char op = s.nextLine().toLowerCase().charAt(0);

            if (op != 's') break;
        }

        System.out.println();
        alunos.forEach(System.out::println);
    }

    private static void leDados(Set<String> set, String campo, int i) {
        while (true) {
            System.out.printf("%s aluno %d: ", campo, i);
            String dado = s.nextLine();

            if (!set.add(dado)) System.out.printf("%s já cadastrado\n", campo);

            System.out.printf("Deseja cadastrar outro %s? ", campo);
            char op = s.nextLine().toLowerCase().charAt(0);

            if (op != 's') break;
        }
    }
}
