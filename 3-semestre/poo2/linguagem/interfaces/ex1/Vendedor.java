package interfaces.ex1;

public class Vendedor extends Funcionario {
	private final double comissao;

	public Vendedor(String nome, String matricula, double salarioBase, double comissao) {
		super(nome, matricula, salarioBase);
		this.comissao = comissao;
	}

	@Override
	double calculaSalario() {
		return super.getSalarioBase() + comissao;
	}
}
