import java.util.Scanner;

public class ERE11 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double soma;
		int pessoas;

		pessoas = 0;
		soma = 0;

		for (double i = s.nextDouble(); i >= 0; i = s.nextDouble()) {
			soma += i;
			pessoas++;
		}

		System.out.printf("R$ %.2f\n", (soma / pessoas));

		s.close();
	}
}
