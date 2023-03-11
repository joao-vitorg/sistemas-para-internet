package linguagem.revisao.ex6;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Ana", 10, 9);
        Aluno aluno2 = new Aluno("Beto", 9, 10);

        System.out.println(aluno1.media());
        System.out.println(aluno2.media());
    }
}
