package heranca.exercicios.ex3;

public class Professor extends Funcionario {
    public Professor() {
    }

    public Professor(String nome, String sobrenome, int matricula, double salario) {
        super(nome, sobrenome, matricula, salario);
    }

    @Override
    public double getSalarioPrimeiraParcela() {
        return getSalario();
    }

    @Override
    public double getSalarioSegundaParcela() {
        return 0;
    }
}
