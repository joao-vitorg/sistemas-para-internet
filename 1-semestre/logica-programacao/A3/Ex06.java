import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ano, preco;
		double taxa;

		ano = s.nextInt();
		preco = s.nextInt();

		taxa = preco * ((ano >= 2000) ? 0.015 : 0.01);

		System.out.printf("Taxa de transferência é %.2f\n", taxa);

		s.close();
	}
}