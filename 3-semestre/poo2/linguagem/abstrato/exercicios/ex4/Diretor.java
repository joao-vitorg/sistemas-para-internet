package abstrato.exercicios.ex4;

public class Diretor extends Funcionario {
    public Diretor(double salarioBase) {
        super(salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() * 1.3;
    }
}
