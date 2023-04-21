package abstrato.exercicios.ex4;

public abstract class Funcionario {
    private double salarioBase;

    public Funcionario(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
