package abstrato.ex4;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Assistente(1000);
        Funcionario funcionario2 = new Gerente(2300);
        Funcionario funcionario3 = new Diretor(5000);

        System.out.println(funcionario1.calcularSalario());
        System.out.println(funcionario2.calcularSalario());
        System.out.println(funcionario3.calcularSalario());
    }
}
