import java.util.Scanner;

public class Ex1051 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Double salario;

		salario = s.nextDouble();

		if (salario <= 2000) {
			System.out.println("Isento");
		} else {
			Double imposto;

			if (salario >= 4500) {
				imposto = (salario - 4500) * 0.28 + 350;
			} else if (salario >= 3000) {
				imposto = (salario - 3000) * 0.18 + 80;
			} else {
				imposto = (salario - 2000) * 0.08;
			}

			System.out.printf("R$ %.2f\n", imposto);
		}

		s.close();
	}
}
