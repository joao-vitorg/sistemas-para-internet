package interfaces.ex1;

public class Assistente extends Funcionario {
	public Assistente(String nome, String matricula, double salarioBase) {
		super(nome, matricula, salarioBase);
	}

	@Override
	double calculaSalario() {
		return super.getSalarioBase();
	}
}
