package abstrato.ex4;

public class Gerente extends Funcionario {
    public Gerente(double salarioBase) {
        super(salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() * 1.2;
    }
}
