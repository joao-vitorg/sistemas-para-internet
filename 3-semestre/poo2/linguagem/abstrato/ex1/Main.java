package abstrato.ex1;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Aluno("joao", "sistemas");
        Pessoa pessoa2 = new Professor("vitor", "segurança");
        Pessoa pessoa3 = new Funcionario("gomes", "programador");

        pessoa1.apresentar();
        pessoa2.apresentar();
        pessoa3.apresentar();
    }
}
