package interfaces.ex1;

import java.util.ArrayList;
import java.util.List;

public class Teste {
	// O funcionario é classe abstrata
	// Gerente, vendedor e assistente é herança de funcionario
	// O metodo calcularSalario é sobrescrito
	// funcionario é uma lista de todos os tipos de funcionario

	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<>();

		funcionarios.add(new Gerente("joao", "1", 3000));
		funcionarios.add(new Assistente("vitor", "2", 1500));
		funcionarios.add(new Vendedor("gomes", "3", 2000, 500));

		System.out.println(funcionarios.stream().mapToDouble(Funcionario::calculaSalario).sum());
	}
}
