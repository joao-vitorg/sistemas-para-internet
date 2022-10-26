import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaAlunos {
    private static final Scanner s = new Scanner(System.in);
    private static final List<Aluno> lista = new ArrayList<>();

    public static void main(String[] args) {
        for (int op = 0; op != 5; ) {
            imprimirMenu();
            op = s.nextInt();
            s.nextLine();

            System.out.println();
            switch (op) {
                case (1) -> cadastrarAluno();
                case (2) -> listarAlunos();
                case (3) -> pesquisarAluno();
                case (4) -> removerAluno();
            }
        }
    }

    private static void imprimirMenu() {
        System.out.print("""
                                
                1 - Cadastrar aluno
                2 - Listar todos os alunos
                3 - Pesquisar aluno
                4 - Remover aluno
                5 - Sair
                                
                Opção:\040""");
    }

    private static void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = s.nextLine();
        System.out.print("Matrícula: ");
        String matricula = s.nextLine();
        System.out.print("Data nascimento: ");
        String dataNascimento = s.nextLine();

        lista.add(new Aluno(nome, matricula, dataNascimento));
    }

    private static void listarAlunos() {
        lista.forEach(System.out::println);
    }

    private static void pesquisarAluno() {
        System.out.print("Matrícula: ");
        String matricula = s.nextLine();

        System.out.println();
        lista.stream().filter(a -> a.getMatricula().equals(matricula)).forEach(System.out::println);
    }

    private static void removerAluno() {
        System.out.print("Matrícula: ");
        String matricula = s.nextLine();

        lista.removeIf(a -> a.getMatricula().equals(matricula));
    }
}