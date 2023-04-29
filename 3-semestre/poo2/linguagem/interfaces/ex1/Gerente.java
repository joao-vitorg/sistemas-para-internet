package interfaces.ex1;

public class Gerente extends Funcionario {
	public Gerente(String nome, String matricula, double salarioBase) {
		super(nome, matricula, salarioBase);
	}

	@Override
	double calculaSalario() {
		return super.getSalarioBase() * 2;
	}
}
