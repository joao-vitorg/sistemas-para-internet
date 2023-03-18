package heranca.exercicios.ex3;

public class Programa {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("João", "Medeiros");
        Funcionario pessoa2 = new Funcionario("Leonardo", "Messias", 100, 1000);
        Professor pessoa3 = new Professor("Antonio", "Silva", 200, 1500);

        System.out.println(pessoa1.getNomeCompleto());
        System.out.println(pessoa2.getNomeCompleto());
        System.out.println(pessoa3.getNomeCompleto());
        System.out.println();

        System.out.println(pessoa2.getSalarioPrimeiraParcela());
        System.out.println(pessoa2.getSalarioSegundaParcela());
        System.out.println();

        System.out.println(pessoa3.getSalarioPrimeiraParcela());
        System.out.println(pessoa3.getSalarioSegundaParcela());
        System.out.println();
    }
}
