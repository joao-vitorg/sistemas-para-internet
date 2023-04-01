package abstrato.ex4;

public class Assistente extends Funcionario {
    public Assistente(double salarioBase) {
        super(salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() * 1.1;
    }
}
