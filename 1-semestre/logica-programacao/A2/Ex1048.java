import java.util.Scanner;

public class Ex1048 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double salario, percentual;

		salario = s.nextDouble();

		if (salario <= 400) {
			percentual = 0.15;
		} else if (salario <= 800) {
			percentual = 0.12;
		} else if (salario <= 1200) {
			percentual = 0.10;
		} else if (salario <= 2000) {
			percentual = 0.07;
		} else {
			percentual = 0.04;
		}

		System.out.printf("Novo salario: %.2f\n", salario * (1 + percentual));
		System.out.printf("Reajuste ganho: %.2f\n", salario * percentual);
		System.out.printf("Em percentual: %.0f %%\n", percentual * 100);

		s.close();
	}
}