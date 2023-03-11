package linguagem.revisao.ex5;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("joao", "123", 19);

        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getCpf());
        System.out.println(pessoa.getIdade());
    }
}
