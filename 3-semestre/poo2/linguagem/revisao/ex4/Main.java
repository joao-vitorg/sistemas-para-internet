package linguagem.revisao.ex4;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("João", 20, 3.5);
        Funcionario funcionario2 = new Funcionario("Matheus", 40, 5.5);
        Funcionario funcionario3 = new Funcionario("Lucas", 40, 13.5);

        System.out.printf("%s R$%.2f%n", funcionario1.nome, funcionario1.horasTrabalhadas * funcionario1.valorHora);
        System.out.printf("%s R$%.2f%n", funcionario2.nome, funcionario2.horasTrabalhadas * funcionario2.valorHora);
        System.out.printf("%s R$%.2f%n", funcionario3.nome, funcionario3.horasTrabalhadas * funcionario3.valorHora);
    }
}
